package pl.agh.arc.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.service.security.ManagementUserDetailsAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Arek on 2016-03-24.
 */
@RestController
public class LoginController {

    private boolean invalidateHttpSession = true;
    private boolean clearAuthentication = true;


    @RequestMapping(value = "/login/user", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public UserWrapper myUser() {
        ManagementUserDetailsAdapter managementUser = (ManagementUserDetailsAdapter) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return new UserWrapper(managementUser.getUsername(), managementUser.getAuthorities());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/auth/logout")
    public boolean logout(HttpServletRequest request, HttpServletResponse response) {
//        if (invalidateHttpSession) {
//            HttpSession session = request.getSession();
//            if (session != null) {
//                session.invalidate();
//            }
//        }
//
//        if (clearAuthentication) {
//            SecurityContext context = SecurityContextHolder.getContext();
//            context.setAuthentication(null);
//        }
//
//        SecurityContextHolder.clearContext();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            new SecurityContextLogoutHandler().logout(request,response,auth);
            auth = null;
            SecurityContextHolder.getContext().setAuthentication(auth);
            SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
        }

        return true;
    }

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
}
