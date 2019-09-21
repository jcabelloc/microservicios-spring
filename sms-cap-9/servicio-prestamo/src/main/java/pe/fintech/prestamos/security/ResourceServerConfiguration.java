package pe.fintech.prestamos.security;


import org.springframework.context.annotation.Configuration;

public class ResourceServerConfiguration {
	
}


/*
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
    @Override
    public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/v1/clientes/**")
                    .hasRole("USER")
                    .anyRequest()
                    .authenticated();
    }
}
*/