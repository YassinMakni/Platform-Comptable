package susitio.comptabilite.project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


	@Value("${spring.datasource.driver-class-name}")
	private String oauthDriver;
	
	@Value("${spring.datasource.url}")
	private String oauthUrl;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
	public TokenStore tokenStore() {
		DataSource tokenDataSource = DataSourceBuilder.create()
				.driverClassName(oauthDriver)
				.username(username)
				.password(password)
				.url(oauthUrl)
				.build();
		return new JdbcTokenStore(tokenDataSource);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        .antMatchers("api/oauth/**","api/login","api/","/api/logout","api/inscription","/api/client/add").permitAll()
		.antMatchers("/api/admin/**").hasAuthority("ADMIN")
		.antMatchers("/api/client/**").hasAuthority("CLIENT")
		.antMatchers("/api/Collaborateur/**").hasAnyAuthority("COLLABORATEUR,ADMIN");
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
	    resources.tokenStore(tokenStore());
	}


}
