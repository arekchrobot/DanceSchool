package pl.agh.arc.dao;

import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.About;

/**
 * Created by Arek on 2016-03-13.
 */
public interface IAboutDao extends CrudRepository<About, Long> {
}
