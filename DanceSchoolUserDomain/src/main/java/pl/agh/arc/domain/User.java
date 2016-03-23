package pl.agh.arc.domain;

import pl.agh.arc.domain.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Arek on 2016-03-20.
 */
@Entity
@Table(name = "management_user")
@SequenceGenerator(name = "default_gen", sequenceName = "user_seq", allocationSize = 1)
public class User extends BaseEntity {

    @Column(name = "username", length = 50)
    @NotNull
    private String username;
    @Column(name = "password")
    @NotNull
    private String password;
    @ManyToMany
    @JoinTable(name = "management_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Collection<Role> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
