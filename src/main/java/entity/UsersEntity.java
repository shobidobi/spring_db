package entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "users", schema = "public", catalog = "login")
public class UsersEntity {//implements UserRepository {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id && Objects.equals(userName, that.userName);
    }
//    public UsersEntity findUser(String userName,UserRepository userRepository){
//        return userRepository.findByUsername(userName);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }

//    @Override
//    public UsersEntity findByUsername(String username) {
//        return null;
//    }
//
//    @Override
//    public <S extends UsersEntity> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends UsersEntity> Iterable<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<UsersEntity> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public Iterable<UsersEntity> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable<UsersEntity> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(UsersEntity entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends UsersEntity> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
}
