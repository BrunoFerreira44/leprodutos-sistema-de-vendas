package br.com.bruno.leprodutos.infrastructure.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Le Produtos - API de vendas",
                version = "1.0.0",
                description = "API de vendas para gerenciamento da loja Le Produtos"
        )
)
public class SwaggerConfig {
}
