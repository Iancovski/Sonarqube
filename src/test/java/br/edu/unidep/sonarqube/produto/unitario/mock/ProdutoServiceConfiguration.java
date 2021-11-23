package br.edu.unidep.sonarqube.produto.unitario.mock;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import br.edu.unidep.sonarqube.service.ProdutoService;

@Profile("test")
@Configuration
public class ProdutoServiceConfiguration {
    @Bean
    @Primary
    public ProdutoService produtoService() {
        return Mockito.mock(ProdutoService.class);
    }
}