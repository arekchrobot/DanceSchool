package pl.agh.arc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.domain.wrappers.ActivityWrapper;
import pl.agh.arc.services.api.IActivityService;

/**
 * Created by Arek on 2016-01-24.
 */
@RestController
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    @RequestMapping(method = RequestMethod.GET, value = "/activity", produces = "application/json;charset=UTF-8")
    public ActivityWrapper getActivity(@RequestParam(value = "activity_name") String activityName) {
        activityName = activityName.replaceAll("\\+", " ");

        return activityService.loadActivity(activityName);
    }
}
