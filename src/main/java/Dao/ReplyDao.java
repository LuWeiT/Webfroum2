package Dao;

import Entity.PostTable;
import Entity.ReplyTable;
import Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ReplyDao {
    public List<ReplyTable> getReplyById(long id) {
        Session session =HibernateUtils.getCurrentSession();
        Query query = session.createQuery("from ReplyTable where postId = :id");
        query.setParameter("id",id);
        return query.list();
    }

    public void addReply(ReplyTable reply) {

        reply.setTime(new Timestamp(new Date().getTime()));

        HibernateUtils.getCurrentSession().save(reply);

        Query query =HibernateUtils.getCurrentSession().createQuery("from PostTable where id=:id");
        query.setParameter("id",reply.getPostId());
        PostTable postTable = (PostTable) query.uniqueResult();
        postTable.setReplayNumber(postTable.getReplayNumber()+1);





    }
}
