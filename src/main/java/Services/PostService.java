package Services;


import Dao.PostDao;
import Entity.PostTable;
import Utils.HibernateUtils;
import org.hibernate.Transaction;

public class PostService {
    PostDao dao =new PostDao();
    public void savePost(PostTable post) {
        Transaction tx =HibernateUtils.getCurrentSession().beginTransaction();
        dao.savePost(post);
        tx.commit();
    }

    public PostTable getPostById(long id) {
        Transaction tx =HibernateUtils.getCurrentSession().beginTransaction();
        PostTable post =dao.getPostById(id);
        tx.commit();
        return post;
    }
}
