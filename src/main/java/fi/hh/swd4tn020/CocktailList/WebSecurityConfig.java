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
				.antMatchers("/delete/{id}").hasAuthority("ADMIN")
				.antMatchers("/lisaaraakaaine/{id}").hasAuthority("ADMIN")
				.antMatchers("/poistacocktail/{id}").hasAuthority("ADMIN")
				.antMatchers("/muutacocktail/{id}").hasAuthority("ADMIN")
				.antMatchers("/poistaraakaaine/{id}").hasAuthority("ADMIN")
				.antMatchers("/muutaraakaaine/{id}").hasAuthority("ADMIN")
				.antMatchers("/lisaa-ainesosa").hasAuthority("ADMIN")
				.antMatchers("/lisaacocktail").hasAuthority("ADMIN")				
				.and()
			.authorizeRequests()
				.antMatchers("/cocktaillista").permitAll()
				.antMatchers("/cocktailit/{id}").permitAll()
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
