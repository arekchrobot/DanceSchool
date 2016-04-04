package pl.agh.arc.rest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.util.Credentials;
import pl.agh.arc.util.SessionUtil;
import pl.agh.arc.util.UserWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Arek on 2016-03-24.
 */
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SessionUtil sessionUtil;


    @RequestMapping(value = "/auth/login", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public UserWrapper login(HttpServletRequest request, HttpServletResponse response, @RequestBody Credentials credentials) {
        UsernamePasswordToken authToken = new UsernamePasswordToken(credentials.getUsername(), credentials.getPassword(), true);
        SecurityUtils.getSubject().login(authToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(credentials.getUsername());
        UserWrapper user =  new UserWrapper(userDetails.getUsername(), userDetails.getAuthorities());
        sessionUtil.setCurrentUser(request, user);
        return user;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/auth/logout")
    public boolean logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityUtils.getSubject().logout();
        sessionUtil.removeCurrentUser(request);
        return true;
    }

    @RequestMapping(value = "/auth/logged", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public UserWrapper isLogged(HttpServletRequest request, HttpServletResponse response) {
        return sessionUtil.getCurrentUser(request);
    }
}
