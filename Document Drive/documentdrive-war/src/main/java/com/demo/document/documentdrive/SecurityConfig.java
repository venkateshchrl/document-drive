package com.demo.document.documentdrive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
@Order(1)
@EnableWebSecurity
@PropertySource("classpath:application.yaml")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private Environment env;
	private static String CLIENT_PROPERTY_KEY 
	  = "spring.security.oauth2.client";
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .oauth2Login()
                .clientRegistrationRepository(clientRegistrationRepository())
                .authorizedClientService(authorizedClientService());
    }
     
    @Bean
    public OAuth2AuthorizedClientService authorizedClientService() {
      
        return new InMemoryOAuth2AuthorizedClientService(
          clientRegistrationRepository());
    }
    
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(getRegistration());
    }
    
    
    private ClientRegistration getRegistration() {
    	String clientId = env.getProperty(
    		      CLIENT_PROPERTY_KEY + ".client-id");
    		 
	    if (clientId == null) {
	        return null;
	    }
	 
	    String clientSecret = env.getProperty(
	      CLIENT_PROPERTY_KEY + ".client-secret");
	  
        return CommonOAuth2Provider.GOOGLE.getBuilder(CommonOAuth2Provider.GOOGLE.toString())
          .clientId(clientId).clientSecret(clientSecret).build();
	  
    }

}