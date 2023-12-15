package entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "users", schema = "public", catalog = "login")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public UsersEntity(String username, String email) {
        this.userName = username;
        this.email = email;
    }

    public UsersEntity() {

    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Basic
    @Column(name = "user_name")
    private String userName;

    public int getId() {
        return id;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Basic
    @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id && Objects.equals(userName, that.userName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }
}
