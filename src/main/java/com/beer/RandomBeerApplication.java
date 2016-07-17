package com.beer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.beer.service.dbinit.IdbInitService;

@SpringBootApplication
public class RandomBeerApplication {

    public static void main(String[] args) {
	SpringApplication.run(RandomBeerApplication.class, args);
    }
    
    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
	return new HibernateJpaSessionFactoryBean();
    }
    
    @Bean
    public InitializingBean init(IdbInitService dbinit) {
	return () -> dbinit.init();
    }
}
