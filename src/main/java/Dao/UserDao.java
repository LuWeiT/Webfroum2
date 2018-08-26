package Dao;

import Entity.UserTable;
import Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;



public class UserDao {

    public UserTable selectUserByUserName(String name) {

        Session session = HibernateUtils.getCurrentSession();
        Query query =session.createQuery("from UserTable  where name = :name");
        query.setParameter("name",name);
        return (UserTable) query.uniqueResult();
    }
    /*@Test
    public  void select(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        UserTable u =selectUserByUserName("lu");
        tx.commit();
        System.out.print(u.getPassword());
    }*/

    public void saveUser(UserTable user) {
        HibernateUtils.getCurrentSession().save(user);
    }
}
