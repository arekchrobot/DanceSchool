package pl.agh.arc.dao;

import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.Activity;

/**
 * Created by Arek on 2016-01-24.
 */
public interface ActivityDao extends CrudRepository<Activity, Long> {

    Activity findByName(String name);
}
