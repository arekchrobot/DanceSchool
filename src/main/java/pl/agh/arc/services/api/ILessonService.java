package pl.agh.arc.services.api;

import java.util.List;
import pl.agh.arc.domain.wrappers.LessonWrapper;

/**
 *
 * @author chrobota
 */
public interface ILessonService {

    List<LessonWrapper> getLessonsForActivity(String activityName);
}
