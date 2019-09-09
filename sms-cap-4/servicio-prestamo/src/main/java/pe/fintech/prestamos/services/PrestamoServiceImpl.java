package pe.fintech.prestamos.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.fintech.prestamos.clients.ClienteDiscoveryClient;
import pe.fintech.prestamos.clients.ClienteFeignClient;
import pe.fintech.prestamos.clients.ClienteRestClient;
import pe.fintech.prestamos.model.Cliente;
import pe.fintech.prestamos.model.Prestamo;
import pe.fintech.prestamos.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService {
	
	@Autowired
	PrestamoRepository prestamoRepository;
	
	@Autowired
	ClienteDiscoveryClient clienteDiscoveryClient;
	
	@Autowired 
	ClienteRestClient clienteRestClient;
	
	@Autowired
	ClienteFeignClient clienteFeignClient;
	
	@Override
	@Transactional
	public List<Prestamo> findByCodCliente(Integer codCliente) {
		return prestamoRepository.findByCodCliente(codCliente);
	}

	@Override
	@Transactional
	public Prestamo findByCodClienteAndCodPrestamo(Integer codCliente, Integer codPrestamo) {
		return prestamoRepository.findByCodClienteAndCodPrestamo(codCliente, codPrestamo);
	}

	@Override
	@Transactional
	public Prestamo create(Prestamo prestamo) {
		return prestamoRepository.save(prestamo);
	}

	@Override
	@Transactional
	public void update(Prestamo prestamo) {
		prestamoRepository.save(prestamo);
	}

	@Override
	public Prestamo findByCodClienteAndCodPrestamoAndTipoLlamada(Integer codCliente, Integer codPrestamo,
			String tipoLlamada) {
		Prestamo prestamo = prestamoRepository.findByCodClienteAndCodPrestamo(codCliente, codPrestamo);
		Cliente cliente = retrieveClienteInfo(codCliente, tipoLlamada);
		
		return prestamo
				.withNombreCliente(cliente.getNombre())
				.withEmailCliente(cliente.getEmail())
				.withTelefonoCliente(cliente.getTelefono());
	}
	
    private Cliente retrieveClienteInfo(Integer codCliente, String tipoLlamada){
        Cliente cliente= null;

        switch (tipoLlamada) {
            case "feign":
                System.out.println("Usando el feign client");
                cliente = clienteFeignClient.getCliente(codCliente);
                break;
            case "rest":
                System.out.println("Usando el rest client");
                cliente = clienteRestClient.getCliente(codCliente);
                break;
            case "discovery":
                System.out.println("Usando el discovery client");
                cliente = clienteDiscoveryClient.getCliente(codCliente);
                break;
            default:
            	cliente = clienteRestClient.getCliente(codCliente);
        }
        return cliente;
    }

}
