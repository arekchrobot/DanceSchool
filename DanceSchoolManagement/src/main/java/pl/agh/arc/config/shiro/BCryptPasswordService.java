package pl.agh.arc.config.shiro;

import org.apache.shiro.authc.credential.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import pl.agh.arc.ManagementSecurityProperties;

/**
 * Created by Arek on 2016-03-30.
 */
@Component
public class BCryptPasswordService implements PasswordService {

    private static final Logger logger = LoggerFactory.getLogger(BCryptPasswordService.class);

    @Autowired
    private ManagementSecurityProperties managementSecurityProperties;

    @Override
    public String encryptPassword(Object plaintextPassword) throws IllegalArgumentException {
        final String str;
        if (plaintextPassword instanceof char[]) {
            str = new String((char[]) plaintextPassword);
        } else if (plaintextPassword instanceof String) {
            str = (String) plaintextPassword;
        } else {
            throw new SecurityException("Unsupported password type: " + plaintextPassword.getClass().getName());
        }
        return BCrypt.hashpw(str, BCrypt.gensalt(managementSecurityProperties.getBcryptStrength()));
    }

    @Override
    public boolean passwordsMatch(Object submittedPlaintext, String encrypted) {
        return BCrypt.checkpw(new String((char[]) submittedPlaintext), encrypted);
    }
}
