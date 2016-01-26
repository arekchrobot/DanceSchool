package pl.agh.arc.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Arek on 2016-01-24.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Column(name = "id")
    private Long id;

    @Version
    private Long version;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
