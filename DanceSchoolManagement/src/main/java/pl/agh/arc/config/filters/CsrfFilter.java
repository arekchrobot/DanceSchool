package pl.agh.arc.config.filters;

/**
 * Created by Arek on 2016-06-04.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Arek on 2016-06-02.
 */
public final class CsrfFilter extends OncePerRequestFilter {
    public static final RequestMatcher DEFAULT_CSRF_MATCHER = new CsrfFilter.DefaultRequiresCsrfMatcher();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    private final Logger logger2 = LoggerFactory.getLogger(CsrfFilter.class);
    private final CsrfTokenRepository tokenRepository;
    private RequestMatcher requireCsrfProtectionMatcher = new CsrfFilter.DefaultRequiresCsrfMatcher();
    private AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandlerImpl();

//    org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository

    public CsrfFilter(CsrfTokenRepository csrfTokenRepository) {
        Assert.notNull(csrfTokenRepository, "csrfTokenRepository cannot be null");
        this.tokenRepository = csrfTokenRepository;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("Inside my CSRF TOKEN FILTER");
        Object csrfToken = this.tokenRepository.loadToken(request);
        boolean missingToken = csrfToken == null;
        if(missingToken) {
            CsrfToken actualToken = this.tokenRepository.generateToken(request);
            csrfToken = new CsrfFilter.SaveOnAccessCsrfToken(this.tokenRepository, request, response, actualToken);
        }

        request.setAttribute(CsrfToken.class.getName(), csrfToken);
        request.setAttribute(((CsrfToken)csrfToken).getParameterName(), csrfToken);
        if(!this.requireCsrfProtectionMatcher.matches(request)) {
            filterChain.doFilter(request, response);
        } else {
            String actualToken1 = request.getHeader(((CsrfToken)csrfToken).getHeaderName());
            if(actualToken1 == null) {
                actualToken1 = request.getParameter(((CsrfToken)csrfToken).getParameterName());
            }

            if(!((CsrfToken)csrfToken).getToken().equals(actualToken1)) {
                if(this.logger.isDebugEnabled()) {
                    this.logger.debug("Invalid CSRF token found for " + UrlUtils.buildFullRequestUrl(request));
                }

                if(missingToken) {
                    this.accessDeniedHandler.handle(request, response, new MissingCsrfTokenException(actualToken1));
                } else {
                    this.accessDeniedHandler.handle(request, response, new InvalidCsrfTokenException((CsrfToken)csrfToken, actualToken1));
                }

            } else {
                filterChain.doFilter(request, response);
            }
        }
        logger.info("Outside my CSRF TOKEN FILTER");
    }

    public void setRequireCsrfProtectionMatcher(RequestMatcher requireCsrfProtectionMatcher) {
        Assert.notNull(requireCsrfProtectionMatcher, "requireCsrfProtectionMatcher cannot be null");
        this.requireCsrfProtectionMatcher = requireCsrfProtectionMatcher;
    }

    public void setAccessDeniedHandler(AccessDeniedHandler accessDeniedHandler) {
        Assert.notNull(accessDeniedHandler, "accessDeniedHandler cannot be null");
        this.accessDeniedHandler = accessDeniedHandler;
    }

    private static final class DefaultRequiresCsrfMatcher implements RequestMatcher {
        private Pattern allowedMethods;

        private DefaultRequiresCsrfMatcher() {
            this.allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
        }

        public boolean matches(HttpServletRequest request) {
            return !this.allowedMethods.matcher(request.getMethod()).matches();
        }
    }

    private static final class SaveOnAccessCsrfToken implements CsrfToken {
        private transient CsrfTokenRepository tokenRepository;
        private transient HttpServletRequest request;
        private transient HttpServletResponse response;
        private final CsrfToken delegate;

        public SaveOnAccessCsrfToken(CsrfTokenRepository tokenRepository, HttpServletRequest request, HttpServletResponse response, CsrfToken delegate) {
            this.tokenRepository = tokenRepository;
            this.request = request;
            this.response = response;
            this.delegate = delegate;
        }

        public String getHeaderName() {
            return this.delegate.getHeaderName();
        }

        public String getParameterName() {
            return this.delegate.getParameterName();
        }

        public String getToken() {
            this.saveTokenIfNecessary();
            return this.delegate.getToken();
        }

        public String toString() {
            return "SaveOnAccessCsrfToken [delegate=" + this.delegate + "]";
        }

        public int hashCode() {
            boolean prime = true;
            byte result = 1;
            int result1 = 31 * result + (this.delegate == null?0:this.delegate.hashCode());
            return result1;
        }

        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            } else if(obj == null) {
                return false;
            } else if(this.getClass() != obj.getClass()) {
                return false;
            } else {
                CsrfFilter.SaveOnAccessCsrfToken other = (CsrfFilter.SaveOnAccessCsrfToken)obj;
                if(this.delegate == null) {
                    if(other.delegate != null) {
                        return false;
                    }
                } else if(!this.delegate.equals(other.delegate)) {
                    return false;
                }

                return true;
            }
        }

        private void saveTokenIfNecessary() {
            if(this.tokenRepository != null) {
                synchronized(this) {
                    if(this.tokenRepository != null) {
                        this.tokenRepository.saveToken(this.delegate, this.request, this.response);
                        this.tokenRepository = null;
                        this.request = null;
                        this.response = null;
                    }

                }
            }
        }
    }
}
