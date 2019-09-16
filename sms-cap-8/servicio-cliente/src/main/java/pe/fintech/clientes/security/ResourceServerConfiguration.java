package pe.fintech.clientes.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

public class ResourceServerConfiguration {
	
}
/*
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
	
	
	//@Override
    //public void configure(HttpSecurity http) throws Exception {
	//	http.authorizeRequests().anyRequest().authenticated();
	//}
	
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers(HttpMethod.PUT, "/v1/clientes/**")
                    .hasRole("ADMIN")
                    .anyRequest()
                    .authenticated();
    }
    
}
*/