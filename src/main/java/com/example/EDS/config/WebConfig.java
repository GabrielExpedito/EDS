package com.example.EDS.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a configuração a todos os endpoints da API
                .allowedOrigins("http://localhost:5173") // Permite requisições somente do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true); // Permite credenciais, como cookies
    }
}