package pl.agh.arc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author chrobota
 */
@Entity
@Table(name = "news")
@SequenceGenerator(name = "default_gen", sequenceName = "news_seq", allocationSize = 1)
public class News extends BaseEntity {

    private static final long serialVersionUID = -8584016237725767967L;

    @Column(name = "title", length = 75)
    @Size(max = 75)
    private String title;
    
    @Column(name = "description", length = 1000)
    @Size(max = 1000)
    private String description;
    
    @Column(name = "image", length = 100)
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
