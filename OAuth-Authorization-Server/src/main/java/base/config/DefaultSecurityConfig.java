package base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import base.service.CustomAuthenticationProvider;

@EnableWebSecurity
public class DefaultSecurityConfig {

	@Autowired
	private CustomAuthenticationProvider customAuthProvider;

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests(authorizeRequestes -> authorizeRequestes.anyRequest().authenticated());

		return httpSecurity.formLogin(Customizer.withDefaults()).build();

	}

	@Autowired
	public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
		authenticationManagerBuilder.authenticationProvider(customAuthProvider);

	}

}
