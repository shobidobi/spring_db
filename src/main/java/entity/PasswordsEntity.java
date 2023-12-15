package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "passwords", schema = "public", catalog = "login")
public class PasswordsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "user_id")
    private int userId;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Basic
    @Column(name = "date")
    private LocalDate date;

    public PasswordsEntity(String password, int id, LocalDate date) {
        this.password = password;
        this.userId = id;
        this.date = date;
    }

    public PasswordsEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordsEntity that = (PasswordsEntity) o;
        return id == that.id && userId == that.userId && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, userId);
    }




}
