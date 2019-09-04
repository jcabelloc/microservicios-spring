package pe.fintech.prestamos.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.fintech.prestamos.model.Prestamo;

@RestController
@RequestMapping(path="v1/clientes/{codCliente}/prestamos")
public class PrestamoController {
	
	@GetMapping("/{codPrestamo}")
	public Prestamo getPrestamo(@PathVariable Integer codCliente, @PathVariable Integer codPrestamo) {
		
		return new Prestamo().withCodPrestamo(codPrestamo)
				.withFechaSolicitud(LocalDate.now())
				.withMonto(BigDecimal.valueOf(3000))
				.withCodCliente(codCliente)
				.withEstado(Prestamo.Estado.SOLICITADO);
			
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public String createPrestamo(@RequestBody Prestamo prestamo) {
		return "POST: Funcionalidad pendiente";
	}
		
	@PutMapping("/{codPrestamo}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
	public String updatePrestamo(@PathVariable Integer codPrestamo, @RequestBody Prestamo prestamo) {
		return "PUT: Funcionalidad pendiente";
	}
	

}
