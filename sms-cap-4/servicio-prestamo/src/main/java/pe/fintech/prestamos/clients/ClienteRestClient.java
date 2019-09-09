package pe.fintech.prestamos.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pe.fintech.prestamos.model.Cliente;

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
}
