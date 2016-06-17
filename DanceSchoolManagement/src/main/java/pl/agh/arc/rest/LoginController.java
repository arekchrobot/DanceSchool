package pl.agh.arc.rest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.exceptions.RestException;
import pl.agh.arc.util.Credentials;
import pl.agh.arc.util.HttpUtil;
import pl.agh.arc.util.SessionUtil;
import pl.agh.arc.util.UserWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Arek on 2016-03-24.
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SessionUtil sessionUtil;


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserWrapper login(HttpServletRequest request, HttpServletResponse response, @RequestBody Credentials credentials) throws RestException {
        UsernamePasswordToken authToken = new UsernamePasswordToken(credentials.getUsername(), credentials.getPassword(), true);
        try {
            logger.info("Logging user: " + credentials.getUsername());
            SecurityUtils.getSubject().login(authToken);
            UserDetails userDetails = userDetailsService.loadUserByUsername(credentials.getUsername());
            UserWrapper user = new UserWrapper(userDetails.getUsername(), userDetails.getAuthorities());
            sessionUtil.setCurrentUser(request, user);
            return user;
        } catch (AuthenticationException exception) {
            logger.info("Not user found with username: " + credentials.getUsername() + " and password: " + credentials.getPassword());
            throw new RestException("Błąd logowania użytkownika.", HttpStatus.UNAUTHORIZED, HttpUtil.generateOriginalUrl(request));
        }
    }

    @RequestMapping( value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean logout(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Logging out user: " + sessionUtil.getCurrentUser(request).getUsername());
        SecurityUtils.getSubject().logout();
        sessionUtil.removeCurrentUser(request);
        return true;
    }

    @RequestMapping(value = "/logged", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserWrapper isLogged(HttpServletRequest request, HttpServletResponse response) {
        return sessionUtil.getCurrentUser(request);
    }
}
