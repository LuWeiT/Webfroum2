package Services;

import Dao.UserDao;
import Entity.UserTable;
import Utils.HibernateUtils;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginService {
    UserDao userDao =new UserDao();
    public UserTable login(UserTable user) throws RuntimeException{
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx=session.beginTransaction();
        UserTable u =new UserTable();

        u = userDao.selectUserByUserName(user.getName());

        tx.commit();

        if(u == null)throw new RuntimeException("用户不存在！");

        if(!u.getPassword().equals(user.getPassword())){
            throw new RuntimeException("密码错误！");

        }
        return u;


    }
}
