package fi.hh.swd4tn020.CocktailList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.hh.swd4tn020.CocktailList.web.UserDetailService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailService userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/delete/{id}").hasRole("ADMIN")
				.antMatchers("/lisaaraakaaine/{id}").hasRole("ADMIN")
				.antMatchers("/poistacocktail/{id}").hasRole("ADMIN")
				.antMatchers("/muutacocktail/{id}").hasRole("ADMIN")
				.antMatchers("/poistaraakaaine/{id}").hasRole("ADMIN")
				.antMatchers("/muutaraakaaine/{id}").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/cocktaillista")
				.permitAll()
				.and()
			.logout()
				.permitAll();		
	}
	
	@Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
