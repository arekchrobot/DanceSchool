package pl.agh.arc.services.api;

import pl.agh.arc.domain.wrappers.ActivityWrapper;
import pl.agh.arc.domain.wrappers.InstructorWrapper;

import java.util.List;

/**
 * Created by Arek on 2016-01-24.
 */
public interface IActivityService {
    ActivityWrapper loadActivity(String activityName);

    List<InstructorWrapper> loadAllInstructors();
}
