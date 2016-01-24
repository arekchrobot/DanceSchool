package pl.agh.arc.domain.wrappers;

import pl.agh.arc.domain.Activity;

import java.util.List;

/**
 * Created by Arek on 2016-01-24.
 */
public class ActivityWrapper {

    private List<byte[]> gallery;
    private List<InstructorWrapper> instructors;
    private String name;
    private String description;
    private String videoUrl;

    public ActivityWrapper(Activity activity) {

        this.name = activity.getName();
        this.description = activity.getDescription();
        this.videoUrl = activity.getVideoUrl();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<byte[]> getGallery() {
        return gallery;
    }

    public void setGallery(List<byte[]> gallery) {
        this.gallery = gallery;
    }

    public List<InstructorWrapper> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<InstructorWrapper> instructors) {
        this.instructors = instructors;
    }
}
