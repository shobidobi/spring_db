package Repository;

import entity.TryLoginEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TryLoginRepository extends CrudRepository<TryLoginEntity, Integer> {
    TryLoginEntity findByUserName(String userName);

}
