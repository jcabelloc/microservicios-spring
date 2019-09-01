package pe.fintech.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(path="/api")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/{primerNombre}/{primerApellido}")
	public String prueba(@PathVariable("primerNombre") String primerNombre, 
				@PathVariable("primerApellido") String primerApellido)  {
		
		return String.format("{\"mensaje\": \"Hola %s %s\"}", primerNombre, primerApellido);
	}

}
