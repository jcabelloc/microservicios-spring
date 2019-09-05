package pe.fintech.prestamos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FintechConfig {

	
	@Value("${propiedad.ejemplo}")
	private String propiedadEjemplo;
	
	public String getPropiedadEjemplo() {
		return propiedadEjemplo;
	}
}
