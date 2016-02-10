package pl.agh.arc.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.arc.dao.IActivityDao;
import pl.agh.arc.dao.ILessonDao;
import pl.agh.arc.domain.Activity;
import pl.agh.arc.domain.Lesson;
import pl.agh.arc.domain.wrappers.LessonWrapper;
import pl.agh.arc.services.api.ILessonService;

/**
 *
 * @author chrobota
 */
@Service
@Transactional
public class LessonService implements ILessonService {

    @Autowired
    private ILessonDao lessonDao;
    @Autowired
    private IActivityDao activityDao;
    
    private static final Comparator<Lesson> weekDayOrdering = (lesson1, lesson2) 
            -> lesson1.getWeekDay().getWeight() - lesson2.getWeekDay().getWeight();
    private static final Comparator<Lesson> startTimeOrdering = (lesson1, lesson2) 
            -> getHourMinuteFromLesson(lesson1) - getHourMinuteFromLesson(lesson2);
    
    public List<LessonWrapper> getLessonsForActivity(String activityName) {
        Activity activity = activityDao.findByName(activityName);
        
        return convertToWrapper(lessonDao.findByInstructorIn(activity.getInstructors()).stream()
                .sorted(weekDayOrdering.thenComparing(startTimeOrdering))
                .collect(Collectors.toList()));
    }
    
    private List<LessonWrapper> convertToWrapper(List<Lesson> lessons) {
        List<LessonWrapper> wrappers = new ArrayList<>();
        
        for (Lesson lesson : lessons) {
            wrappers.add(new LessonWrapper(lesson));
        }
        return wrappers;
    }
    
    private static int getHourFromLesson(Lesson lesson) {
        return Integer.parseInt(lesson.getHour().split(":")[0]);
    }
    
    private static int getMinuteFromLesson(Lesson lesson) {
        return Integer.parseInt(lesson.getHour().split(":")[1]);
    }
    
    private static int getHourMinuteFromLesson(Lesson lesson) {
        return getHourFromLesson(lesson) + getMinuteFromLesson(lesson);
    }
}
