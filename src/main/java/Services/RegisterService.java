package Services;

import Dao.UserDao;
import Entity.UserTable;
import Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegisterService {
        UserDao userDao = new UserDao();
    public void register(UserTable user) throws RuntimeException {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        UserTable userTable = userDao.selectUserByUserName(user.getName());
        if(userTable!=null){
            tx.rollback();
            throw new RuntimeException("用户名已存在！");
        }
        else{
            userDao.saveUser(user);
        }
        tx.commit();
    }
}
