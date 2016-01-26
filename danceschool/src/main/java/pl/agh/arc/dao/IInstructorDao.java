package pl.agh.arc.dao;

import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.Activity;
import pl.agh.arc.domain.Instructor;

import java.util.List;

/**
 * Created by Arek on 2016-01-24.
 */
public interface IInstructorDao extends CrudRepository<Instructor, Long> {

    List<Instructor> findByActivity(Activity activity);
}
