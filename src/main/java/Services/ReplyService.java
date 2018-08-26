package Services;

import Dao.ReplyDao;
import Entity.ReplyTable;
import Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReplyService {
    ReplyDao dao = new ReplyDao();
    public List<ReplyTable> getReplyByPostId(long id) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<ReplyTable> replyTables =dao.getReplyById(id);

        tx.commit();
        return replyTables;
    }

    public void addReply(ReplyTable reply) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        dao.addReply(reply);

        tx.commit();

    }
}
