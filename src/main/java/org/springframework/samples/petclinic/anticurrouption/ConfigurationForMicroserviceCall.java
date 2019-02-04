package org.springframework.samples.petclinic.anticurrouption;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationForMicroserviceCall {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
