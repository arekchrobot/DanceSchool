package pl.agh.arc.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Arek on 2016-01-24.
 */
@Entity
@Table(name = "activity")
@SequenceGenerator(name = "default_gen", sequenceName = "activity_seq", allocationSize = 1)
public class Activity extends BaseEntity {

    private static final long serialVersionUID = -2000357371215716394L;

    @OneToMany(mappedBy = "activity", fetch = FetchType.EAGER)
    private List<Instructor> instructors;

    @Column(name = "name_", length = 100, unique = true)
    @NotNull
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "video_url", length = 150)
    private String videoUrl;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "gallery",
            joinColumns = @JoinColumn(name = "activity_id"))
    @Column(name = "photo_location", length = 70)
    private List<String> gallery;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
