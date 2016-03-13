package pl.agh.arc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Arek on 2016-03-13.
 */
@Entity
@Table(name = "about")
@SequenceGenerator(name = "default_gen", sequenceName = "about_seq", allocationSize = 1)
public class About extends BaseEntity {

    @Column(name = "description", length = 1000)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
