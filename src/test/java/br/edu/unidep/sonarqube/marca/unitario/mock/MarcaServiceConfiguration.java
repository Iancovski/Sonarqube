package br.edu.unidep.sonarqube.marca.unitario.mock;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import br.edu.unidep.sonarqube.service.MarcaService;

@Profile("test")
@Configuration
public class MarcaServiceConfiguration {
    @Bean
    @Primary
    public MarcaService marcaService() {
        return Mockito.mock(MarcaService.class);
    }
}