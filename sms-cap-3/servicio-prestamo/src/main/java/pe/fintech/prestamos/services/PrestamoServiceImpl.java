package pe.fintech.prestamos.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.fintech.prestamos.model.Prestamo;
import pe.fintech.prestamos.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService {
	
	@Autowired
	PrestamoRepository prestamoRepository;
	
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

}
