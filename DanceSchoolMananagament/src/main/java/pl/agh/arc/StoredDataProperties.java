package pl.agh.arc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Arek on 2016-01-24.
 */
@ConfigurationProperties("app.stored.data")
@Component
public class StoredDataProperties {

    private String basePath = "/";
    private String activityPath = "/";
    private String instructorPath = "/";
    private String newsPath = "/";

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getActivityPath() {
        return activityPath;
    }

    public void setActivityPath(String activityPath) {
        this.activityPath = activityPath;
    }

    public String getInstructorPath() {
        return instructorPath;
    }

    public void setInstructorPath(String instructorPath) {
        this.instructorPath = instructorPath;
    }

    public String getNewsPath() {
        return newsPath;
    }

    public void setNewsPath(String newsPath) {
        this.newsPath = newsPath;
    }
}
