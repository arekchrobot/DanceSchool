package pl.agh.arc.domain.wrappers;

import pl.agh.arc.domain.Instructor;

/**
 * Created by Arek on 2016-01-24.
 */
public class InstructorWrapper {

    private String name;
    private String description;
    private byte[] image;

    public InstructorWrapper(Instructor instructor) {
        this.name = instructor.getName();
        this.description = instructor.getDescription();
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
