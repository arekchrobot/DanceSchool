package pl.agh.arc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.arc.dao.IActivityDao;
import pl.agh.arc.domain.Activity;
import pl.agh.arc.domain.Instructor;
import pl.agh.arc.domain.wrappers.ActivityWrapper;
import pl.agh.arc.domain.wrappers.InstructorWrapper;
import pl.agh.arc.services.api.IActivityService;
import pl.agh.arc.util.IterableToListConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arek on 2016-01-24.
 */
@Service
@Transactional
public class ActivityService implements IActivityService {

    @Autowired
    private IActivityDao activityDao;

    @Autowired
    private ImageResolver imageResolver;

    @Override
    public ActivityWrapper loadActivity(String activityName) {
        Activity loadedActivity = activityDao.findByName(activityName);
        return convertToWrapper(loadedActivity);
    }

    @Override
    public List<InstructorWrapper> loadAllInstructors() {
        List<Activity> allActivities = IterableToListConverter.convertToList(activityDao.findAll());
        List<InstructorWrapper> result = new ArrayList<>();
        for (Activity activity : allActivities) {
            result.addAll(convertInstructors(activity.getInstructors()));
        }
        return result;
    }

    private ActivityWrapper convertToWrapper(Activity activity) {
        ActivityWrapper wrapper = new ActivityWrapper(activity);
        wrapper.setGallery(imageResolver.resolveImage(activity));
        wrapper.setInstructors(convertInstructors(activity.getInstructors()));

        return wrapper;
    }

    private List<InstructorWrapper> convertInstructors(List<Instructor> instructors) {
        List<InstructorWrapper> wrappers = new ArrayList<>();

        for (Instructor instructor : instructors) {
            InstructorWrapper wrapper = new InstructorWrapper(instructor);
            wrapper.setImage(imageResolver.resolveImage(instructor));

            wrappers.add(wrapper);
        }

        return wrappers;
    }
}
