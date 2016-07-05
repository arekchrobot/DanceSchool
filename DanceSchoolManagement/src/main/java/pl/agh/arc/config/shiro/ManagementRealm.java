package pl.agh.arc.config.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.agh.arc.dao.UserDao;
import pl.agh.arc.domain.Permission;
import pl.agh.arc.domain.Role;
import pl.agh.arc.domain.User;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by Arek on 2016-03-30.
 */
@Component
public class ManagementRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username;
        try {
            username = (String) principalCollection.fromRealm(getName()).iterator().next();
        } catch (NoSuchElementException ex) {
            return null;
        }
        User user = userDao.findByUsername(username);

        if (user != null) {
            Set<String> roles = new HashSet<>();
            Set<String> perms = new HashSet<>();
            for (Role role : user.getRoles()) {
                roles.add(role.getAuthority());
                for (Permission perm : role.getPermissions()) {
                    perms.add(perm.getAuthority());
                }
            }
            SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo(roles);
            authInfo.setStringPermissions(perms);

            return authInfo;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken authToken = (UsernamePasswordToken) authenticationToken;

        User user = userDao.findByUsername(authToken.getUsername());

        if (user == null) {
            throw new UsernameNotFoundException("Account does not exists");
        }

        return new SimpleAuthenticationInfo(authToken.getUsername(), user.getPassword(), getName());
    }
}
