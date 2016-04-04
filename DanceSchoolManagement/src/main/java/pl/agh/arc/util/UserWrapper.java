package pl.agh.arc.util;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Arek on 2016-03-31.
 */
public class UserWrapper {
    private String username;
    private Collection<String> perms;

    public UserWrapper(String username, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.perms = authorities.stream().map(a -> a.getAuthority()).collect(Collectors.toList());
    }

    public String getUsername() {
        return username;
    }

    public Collection<String> getPerms() {
        return perms;
    }
}
