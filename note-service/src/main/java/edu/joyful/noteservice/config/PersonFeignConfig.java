package edu.joyful.noteservice.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class PersonFeignConfig {

    

    @Bean
    public BasicAuthRequestInterceptor feignAuthInterceptor(
            @Value("${person.service.username:default_user}") String username,
            @Value("${person.service.password:default_pass}") String password
    ) {
        return new BasicAuthRequestInterceptor(username, password);
    }
}
