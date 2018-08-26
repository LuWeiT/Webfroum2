package Entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "post_table", schema = "webforum", catalog = "")
public class PostTable {
    private long id;
    private String title;
    private String content;
    private String username;
    private Integer replayNumber;
    private Timestamp time;
    private Long userId;
    private UserTable userTableByUserId;
    private Collection<ReplyTable> replyTablesById;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "replayNumber", nullable = true)
    public Integer getReplayNumber() {
        return replayNumber;
    }

    public void setReplayNumber(Integer replayNumber) {
        this.replayNumber = replayNumber;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostTable postTable = (PostTable) o;

        if (id != postTable.id) return false;
        if (title != null ? !title.equals(postTable.title) : postTable.title != null) return false;
        if (content != null ? !content.equals(postTable.content) : postTable.content != null) return false;
        if (username != null ? !username.equals(postTable.username) : postTable.username != null) return false;
        if (replayNumber != null ? !replayNumber.equals(postTable.replayNumber) : postTable.replayNumber != null)
            return false;
        if (time != null ? !time.equals(postTable.time) : postTable.time != null) return false;
        if (userId != null ? !userId.equals(postTable.userId) : postTable.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (replayNumber != null ? replayNumber.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",insertable=false ,updatable=false)
    public UserTable getUserTableByUserId() {
        return userTableByUserId;
    }

    public void setUserTableByUserId(UserTable userTableByUserId) {
        this.userTableByUserId = userTableByUserId;
    }

    @OneToMany(mappedBy = "postTableByPostId")
    public Collection<ReplyTable> getReplyTablesById() {
        return replyTablesById;
    }

    public void setReplyTablesById(Collection<ReplyTable> replyTablesById) {
        this.replyTablesById = replyTablesById;
    }
}
