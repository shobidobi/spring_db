package Repository;

import entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity,Integer> {
    Optional<UsersEntity> findUsersEntityByUserNameContaining(String userName);
    Optional<UsersEntity> findUsersEntityByEmail(String Email);

}
