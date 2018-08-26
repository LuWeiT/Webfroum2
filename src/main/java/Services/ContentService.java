package Services;

import Dao.ContentDao;
import Entity.PostTable;
import Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ContentService {
    ContentDao dao = new ContentDao();
    public List<PostTable> getAllPost() {
        Session  session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<PostTable> list = dao.selectAllPost();
        tx.commit();
        return list;
    }
}
