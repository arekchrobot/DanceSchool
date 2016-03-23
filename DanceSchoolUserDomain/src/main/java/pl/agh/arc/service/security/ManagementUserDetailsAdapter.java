package pl.agh.arc.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.agh.arc.domain.Permission;
import pl.agh.arc.domain.Role;
import pl.agh.arc.domain.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arek on 2016-03-23.
 */
public class ManagementUserDetailsAdapter implements UserDetails {

    private User user;

    public ManagementUserDetailsAdapter(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<Permission> permissions = new HashSet<>();
        for (Role role : user.getRoles()) {
            permissions.addAll(role.getPermissions());
        }
        authorities.addAll(permissions);
        authorities.addAll(user.getRoles());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
