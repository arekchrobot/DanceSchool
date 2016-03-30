package pl.agh.arc;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.arc.domain.User;
import pl.agh.arc.service.security.ManagementUserDetailsAdapter;

import java.security.Principal;
import java.util.Collection;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
//@RestController
public class DanceSchoolManagementApplication {

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};

		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

//	@RequestMapping("/user")
//	public User user(Principal user) {
//		User managementUser = ((ManagementUserDetailsAdapter) SecurityContextHolder
//				.getContext().getAuthentication().getPrincipal()).getUser();
//		return managementUser;
////		return user;
//	}

//	@RequestMapping(value = "/secured/user", produces = "application/json;charset=UTF-8")
//	 public UserWrapper myUser(Principal user) {
//		ManagementUserDetailsAdapter managementUser = (ManagementUserDetailsAdapter) SecurityContextHolder
//				.getContext().getAuthentication().getPrincipal();
//		return new UserWrapper(managementUser.getUsername(), managementUser.getAuthorities());
////		return user;
//	}
//
//	public class UserWrapper {
//		private String username;
//		private Collection<GrantedAuthority> authorities;
//
//		public UserWrapper(String username, Collection<? extends GrantedAuthority> authorities) {
//			this.username = username;
//			this.authorities = (Collection<GrantedAuthority>) authorities;
//		}
//
//		public String getUsername() {
//			return username;
//		}
//
//		public Collection<GrantedAuthority> getAuthorities() {
//			return authorities;
//		}
//	}

	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8090);
		connector.setSecure(false);
		connector.setRedirectPort(8443);

		return connector;
	}

	public static void main(String[] args) {
		SpringApplication.run(DanceSchoolManagementApplication.class, args);
	}
}
