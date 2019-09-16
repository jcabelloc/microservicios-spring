package pe.fintech.prestamos.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pe.fintech.prestamos.model.Cliente;
import pe.fintech.prestamos.utils.UserContextHolder;

@Component
public class ClienteRestClient {
	
	
    @Autowired
    RestTemplate restTemplate;

    public Cliente getCliente(Integer codCliente){
        ResponseEntity<Cliente> restExchange =
                restTemplate.exchange(
                        "http://serviciocliente/v1/clientes/{codCliente}",
                        HttpMethod.GET,
                        null, Cliente.class, codCliente);

        return restExchange.getBody();
    }
    
	/*
    @Autowired
    OAuth2RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ClienteRestClient.class);

    public Cliente getCliente(Integer codCliente){
        logger.debug("En prestamo service getCliente con ID correlativo: {}", UserContextHolder.getContext().getCorrelationId());

        ResponseEntity<Cliente> restExchange =
                restTemplate.exchange(
                        "http://zuulservice/api/cliente/v1/clientes/{codCliente}",
                        HttpMethod.GET,
                        null, Cliente.class, codCliente);

        return restExchange.getBody();
    }
    */
}
