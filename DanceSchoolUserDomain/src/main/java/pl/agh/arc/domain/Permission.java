package pl.agh.arc.domain;

import org.springframework.security.core.GrantedAuthority;
import pl.agh.arc.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Arek on 2016-03-20.
 */
@Entity
@Table(name = "management_permission")
@SequenceGenerator(name = "default_gen", sequenceName = "permission_seq", allocationSize = 1)
public class Permission extends BaseEntity implements GrantedAuthority {

    @Column(name = "name_", length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        GrantedAuthority ga = (GrantedAuthority) o;
        return (getAuthority().equals(ga.getAuthority()));
    }

    @Override
    public int hashCode() {
        return getAuthority().hashCode();
    }
}
