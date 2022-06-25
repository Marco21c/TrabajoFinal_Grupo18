package ar.edu.unju.fi.html;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ar.edu.unju.fi.html.serviceImp.LoginUsuariosServiceImp;

@Configuration
public class WebSegConfiguration{
	@Autowired
	private AutenticacionSuccessHandler autenticacion;

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/images/**", "/js/**", "/layer/**",
			"/webjars/**" };

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
		.authorizeHttpRequests()
		      .antMatchers("/inicio/login").permitAll()
		      .antMatchers(resources).permitAll()
		      .antMatchers("/inicio/menu").permitAll()
		      .antMatchers("/ciudadano/nuevo").permitAll()
		      .antMatchers("/ciudadano/postCiudadano").permitAll()
		      .antMatchers("/empleador/postEmpleador").permitAll()
		      .antMatchers("/empleador/nuevo").permitAll()
		      .anyRequest().authenticated()
		      .and()
		.formLogin()
		      .loginPage("/inicio/login").permitAll().successHandler(autenticacion)
		      .failureUrl("/inicio/login?error=true")
		      .usernameParameter("username")
		      .passwordParameter("contraseña")
		      .and()
		.logout()
		    .permitAll();
		   // .logoutSuccessUrl("/inicio/login?logout");

		http.headers().frameOptions().sameOrigin();

		return http.build();
	}

	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}

	@Autowired
	LoginUsuariosServiceImp userDetailsService;
  
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
 
}


