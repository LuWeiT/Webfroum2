package Dao;

import Entity.PostTable;
import Utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;


import java.util.List;

public class ContentDao {
    public List<PostTable> selectAllPost() {
        Session  session = HibernateUtils.getCurrentSession();
        Query query = session.createQuery("from  PostTable ");
        List<PostTable> list =query.list();
        Hibernate.initialize(list);
        //System.out.print(list.get(0).getContent());
        return list;
    }
   /* @Test
    public void select() {

        Session  session = HibernateUtils.getCurrentSession();
        Transaction tx =session.beginTransaction();
        Query query = session.createQuery("from  PostTable ");
        System.out.print(query.list());
        tx.commit();
    }*/
}
