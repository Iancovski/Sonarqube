package br.edu.unidep.sonarqube.cliente.unitario.mock;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import br.edu.unidep.sonarqube.service.ClienteService;

@Profile("test")
@Configuration
public class ClienteServiceConfiguration {
    @Bean
    @Primary
    public ClienteService clienteService() {
        return Mockito.mock(ClienteService.class);
    }
}