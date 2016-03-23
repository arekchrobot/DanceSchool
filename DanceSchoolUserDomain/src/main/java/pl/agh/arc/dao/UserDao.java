package pl.agh.arc.dao;

import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.User;

/**
 * Created by Arek on 2016-03-20.
 */
public interface UserDao extends CrudRepository<User, Long>{

    User findByUsername(String username);
}
