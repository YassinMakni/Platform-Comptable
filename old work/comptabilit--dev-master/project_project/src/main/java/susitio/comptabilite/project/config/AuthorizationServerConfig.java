package susitio.comptabilite.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import susitio.comptabilite.project.services.CustomTokenEnhancer;

@Order(value=10)
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private TokenStore tokenStore;
    
    @Autowired
    PasswordEncoder encoder;
    
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		System.out.println("abc");

		endpoints
    	.authenticationManager(authenticationManager)
    	.tokenStore(tokenStore)
        .userDetailsService(userDetailsService)
        .tokenEnhancer(tokenEnhancer())
        .pathMapping("/oauth/token", "/api/oauth/token");
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
    	.checkTokenAccess("isAuthenticated()")
    	.tokenKeyAccess("permitAll()")
		.passwordEncoder(passwordEncoder());
	}
	

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("client")
			   .authorizedGrantTypes("refresh_token","password")
			   .authorities("CLIENT","ADMIN","COLLABORATEUR")
			   .scopes("read", "write", "trust")
               .resourceIds("oauth2-resource")
               .accessTokenValiditySeconds(10)
               .secret(encoder.encode("secret"))
               .refreshTokenValiditySeconds(60);
	}

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }

	@Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

}
