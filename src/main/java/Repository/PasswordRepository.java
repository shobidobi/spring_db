package Repository;

import entity.PasswordsEntity;
import entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordRepository extends CrudRepository<PasswordsEntity, Integer> {
    PasswordsEntity findByPassword(String password);

    PasswordsEntity findByUserId(Integer userId);
    Optional<PasswordsEntity> findFirstByUserIdOrderByDateDesc(Integer userId);

}
