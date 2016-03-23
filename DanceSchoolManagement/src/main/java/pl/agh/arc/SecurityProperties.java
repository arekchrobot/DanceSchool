package pl.agh.arc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Arek on 2016-03-23.
 */
@ConfigurationProperties("app.security")
@Component
public class SecurityProperties {

    private int bcryptStrength;

    public int getBcryptStrength() {
        return bcryptStrength;
    }

    public void setBcryptStrength(int bcryptStrength) {
        this.bcryptStrength = bcryptStrength;
    }
}
