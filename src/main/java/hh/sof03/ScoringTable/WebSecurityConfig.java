package hh.sof03.ScoringTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import hh.sof03.ScoringTable.web.UserDetailServiceImpl;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;



@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests( authorize -> authorize
		.requestMatchers(toH2Console()).permitAll()
		.anyRequest().authenticated()
		)
		.csrf(csrf -> csrf
			 .ignoringRequestMatchers(toH2Console())
		)
		.headers(headers -> headers
			.frameOptions(frameoptions -> frameoptions
				.disable())
		)
		.formLogin( formlogin -> formlogin
		.defaultSuccessUrl("/players", true)
		.permitAll()
		);
		return http.build();
		}

	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
