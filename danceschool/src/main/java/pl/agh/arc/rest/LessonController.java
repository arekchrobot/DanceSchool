package pl.agh.arc.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.domain.wrappers.LessonWrapper;
import pl.agh.arc.services.api.ILessonService;

/**
 *
 * @author chrobota
 */
@RestController
public class LessonController {

    @Autowired
    private ILessonService lessonService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/lessons", produces = "application/json;charset=UTF-8")
    public List<LessonWrapper> getLessonsForActivity(@RequestParam(value = "activity_name") String activityName) {
        activityName = activityName.replaceAll("\\+", " ");
        
        return lessonService.getLessonsForActivity(activityName);
    }

    @RequestMapping(method = RequestMethod.GET, value="/lessons/all", produces = "application/json;charset=UTF-8")
    public List<LessonWrapper> getAllLessons() {
        return lessonService.getAllLessons();
    }
}
