package Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reply_table", schema = "webforum")
public class ReplyTable {
    private Long postId;
    private String replyContent;
    private String username;
    private Short floor;
    private Timestamp time;
    private long replyId;
    private PostTable postTableByPostId;

    @Basic
    @Column(name = "post_id", nullable = true)
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "reply_content", nullable = true, length = -1)
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "floor", nullable = true)
    public Short getFloor() {
        return floor;
    }

    public void setFloor(Short floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Id
    @Column(name = "reply_id", nullable = false)
    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplyTable that = (ReplyTable) o;

        if (replyId != that.replyId) return false;
        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (replyContent != null ? !replyContent.equals(that.replyContent) : that.replyContent != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (floor != null ? !floor.equals(that.floor) : that.floor != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (replyContent != null ? replyContent.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (int) (replyId ^ (replyId >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id",insertable=false ,updatable=false)
    public PostTable getPostTableByPostId() {
        return postTableByPostId;
    }

    public void setPostTableByPostId(PostTable postTableByPostId) {
        this.postTableByPostId = postTableByPostId;
    }
}
