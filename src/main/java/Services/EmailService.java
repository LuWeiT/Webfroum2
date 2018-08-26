package Services;

import Dao.UserDao;
import Entity.UserTable;
import Utils.HibernateUtils;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class EmailService {
    UserDao userDao = new UserDao();
    public void sendEmail(String email,String username) throws  Exception{

        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        UserTable user =userDao.selectUserByUserName(username);
        tx.commit();
        if(user==null)throw new RuntimeException("用户不存在！");
        if(!user.getEmil().equals(email))throw new RuntimeException("用户名与邮箱地址不匹配！");
        String tempCode =( Math.random()+"").substring(2,8);
        try {
            send(email, username, tempCode);

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("邮件发送失败！");
        }
        ActionContext.getContext().getSession().put("emailCode",tempCode);



    }

    private void send(String email, String username,String tempCode) throws Exception{
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        InputStream in = getClass().getResource("/Email.properties").openStream();
        props.load(in);
       /* props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.enable", "true");
        // 发件人的账号
        props.put("mail.user", "769705252@qq.com");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "atkuvnpqtfeabcbi");
*/
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        javax.mail.Session mailSession = javax.mail.Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人
        InternetAddress to = new InternetAddress(email);
        message.setRecipient(Message.RecipientType.TO, to);

        // 设置抄送，抄送和密送如果不写正确的地址也要报错。最好注释不用。
//        InternetAddress cc = new InternetAddress("");
//        message.setRecipient(RecipientType.CC, cc);
//
//        // 设置密送，其他的收件人不能看到密送的邮件地址
//        InternetAddress bcc = new InternetAddress("");
//        message.setRecipient(RecipientType.CC, bcc);

        // 设置邮件标题
        message.setSubject("密码修改邮件！");

        // 设置邮件的内容体
        message.setContent(username+" 您好！您的验证码为："+tempCode, "text/html;charset=UTF-8");

        // 发送邮件
        Transport.send(message);
    }

   /* @Test
    public void test(){
        try {
            send("769705252@qq.com","reed",(Math.random()+"").toString().substring(2,8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
