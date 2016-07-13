package pl.agh.arc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Arek on 2016-01-24.
 */
@Entity
@Table(name = "instructor")
@SequenceGenerator(name = "default_gen", sequenceName = "instructor_seq", allocationSize = 1)
public class Instructor extends BaseEntity {

    private static final long serialVersionUID = -1335210924816579877L;

    @Column(name = "name_", length = 100)
    @NotNull
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "image", length = 100)
    private String image;

    @ManyToOne
    private Activity activity;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
