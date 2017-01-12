package pl.agh.arc.util;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arek on 2016-03-31.
 */
@Service
public class SessionUtil {

    private final String USER_KEY = "management_user";

    public UserWrapper getCurrentUser(HttpServletRequest request) {
        UserWrapper currentUser = (UserWrapper) request.getSession().getAttribute(USER_KEY);
        if(currentUser == null) {
            return null;
        }
        return currentUser;
    }

    public void setCurrentUser(HttpServletRequest request, UserWrapper currentUser) {
        request.getSession().setAttribute(USER_KEY, currentUser);
    }

    public void removeCurrentUser(HttpServletRequest request) {
        request.getSession().removeAttribute(USER_KEY);
    }
}
