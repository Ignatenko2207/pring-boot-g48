package ua.mainacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.mainacademy.factory.HibernateSessionFactory;
import ua.mainacademy.factory.impl.H2SessionFactory;

@Configuration
public class ApplicationConfig {

    @Bean
    public HibernateSessionFactory getH2SessionFactory() {
        return new H2SessionFactory();
    }

}
