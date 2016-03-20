package pl.agh.arc.dao;

import org.springframework.data.repository.CrudRepository;
import pl.agh.arc.domain.Instructor;
import pl.agh.arc.domain.Lesson;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author chrobota
 */
public interface ILessonDao extends CrudRepository<Lesson, Long>{

    List<Lesson> findByInstructorIn(Collection<Instructor> instructors);
}
