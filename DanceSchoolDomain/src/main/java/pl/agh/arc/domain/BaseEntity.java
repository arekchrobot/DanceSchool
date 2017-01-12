package pl.agh.arc.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Arek on 2016-01-24.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8746819457741245070L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Column(name = "id")
    private Long id;

    @Version
    private long version;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public boolean isNew() {
        return null == getId();
    }
}
