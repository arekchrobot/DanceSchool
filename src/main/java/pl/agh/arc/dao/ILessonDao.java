package pl.agh.arc.dao;

import java.util.Collection;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.Instructor;
import pl.agh.arc.domain.Lesson;

/**
 *
 * @author chrobota
 */
public interface ILessonDao extends CrudRepository<Lesson, Long>{

    List<Lesson> findByInstructorIn(Collection<Instructor> instructors);
}
