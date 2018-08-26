package Dao;

import Entity.PostTable;
import Entity.UserTable;
import Utils.HibernateUtils;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.sql.Timestamp;
import java.util.Date;

public class PostDao {
    public void savePost(PostTable post) {
        Session session = HibernateUtils.getCurrentSession();
        UserTable user = (UserTable) ActionContext.getContext().getSession().get("user");
        post.setUsername(user.getName());
        post.setUserId(user.getUserId());
        post.setReplayNumber(0);
        post.setTime((new Timestamp(new Date().getTime())));
        session.save(post);
    }

    public PostTable getPostById(long id) {
        Session session = HibernateUtils.getCurrentSession();
        Query query = session.createQuery("from PostTable where id = :id");
        query.setParameter("id",id);
        return (PostTable) query.uniqueResult();
    }
}
