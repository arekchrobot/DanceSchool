package pl.agh.arc.services;

import java.util.ArrayList;
import java.util.List;
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
    
    public List<LessonWrapper> getLessonsForActivity(String activityName) {
        Activity activity = activityDao.findByName(activityName);
        return convertToWrapper(lessonDao.findByInstructorIn(activity.getInstructors()));
    }
    
    private List<LessonWrapper> convertToWrapper(List<Lesson> lessons) {
        List<LessonWrapper> wrappers = new ArrayList<>();
        
        for (Lesson lesson : lessons) {
            wrappers.add(new LessonWrapper(lesson));
        }
        return wrappers;
    }
}
