package Services;

import Dao.UserDao;
import Entity.UserTable;
import Utils.HibernateUtils;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {
    UserDao dao = new UserDao();
    public void updateUserPasswordByUsername(String username, String password,String code)   {

        if(!code.equals(ActionContext.getContext().getSession().get("emailCode"))){
            ActionContext.getContext().getSession().remove("emailCode");

            throw new RuntimeException("验证码错误！");
        }
        Session session= HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        UserTable user =dao.selectUserByUserName(username);
        user.setPassword(password);

        tx.commit();
        ActionContext.getContext().getSession().remove("emailCode");

    }
}
