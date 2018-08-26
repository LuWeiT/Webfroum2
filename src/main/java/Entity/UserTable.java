package Entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_table", schema = "webforum", catalog = "")
public class UserTable {
    private String name;
    private String password;
    private String emil;
    private long userId;
    private Collection<PostTable> postTablesByUserId;

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "emil", nullable = true, length = 50)
    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTable userTable = (UserTable) o;

        if (userId != userTable.userId) return false;
        if (name != null ? !name.equals(userTable.name) : userTable.name != null) return false;
        if (password != null ? !password.equals(userTable.password) : userTable.password != null) return false;
        if (emil != null ? !emil.equals(userTable.emil) : userTable.emil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (emil != null ? emil.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "userTableByUserId")
    public Collection<PostTable> getPostTablesByUserId() {
        return postTablesByUserId;
    }

    public void setPostTablesByUserId(Collection<PostTable> postTablesByUserId) {
        this.postTablesByUserId = postTablesByUserId;
    }
}
