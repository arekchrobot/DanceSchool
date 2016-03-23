package pl.agh.arc.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.arc.dao.UserDao;
import pl.agh.arc.domain.User;

/**
 * Created by Arek on 2016-03-23.
 */
@Service("userDetailsService")
@Transactional(readOnly = true)
public class ManagementUserDetailsServiceAdapter implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.findByUsername(login);

        if(user == null) {
            throw new UsernameNotFoundException("No such user: " + login);
        } else if (user.getRoles().isEmpty()) {
            throw new UsernameNotFoundException("User " + login + " has no authorities");
        }

        return new ManagementUserDetailsAdapter(user);
    }
}
