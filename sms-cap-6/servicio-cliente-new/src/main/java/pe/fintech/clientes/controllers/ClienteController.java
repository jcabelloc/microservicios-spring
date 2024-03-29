package pe.fintech.clientes.controllers;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.fintech.clientes.model.Cliente;
import pe.fintech.clientes.services.ClienteService;

@RestController
@RequestMapping(path="v1/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

	
	@GetMapping("/{codCliente}")
	public Cliente getCliente(@PathVariable Integer codCliente) {
		logger.debug("Looking up data for cliente {}",codCliente );
		try {
			Cliente cliente = clienteService.findById(codCliente);
			cliente.setNombre("NEW::" + cliente.getNombre());
			return cliente;
		
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteService.create(cliente);
	}
		
	@PutMapping("/{codCliente}")
	public void updateCliente(@PathVariable Integer codCliente, @RequestBody Cliente cliente) {
		cliente.setCodCliente(codCliente);
		clienteService.update(cliente);
	}
	
	
}
