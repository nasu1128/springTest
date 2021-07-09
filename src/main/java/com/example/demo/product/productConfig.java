package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class productConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product product1 = new Product(
                    "yeet",
                    1,
                    "small"

            );

            Product product2 = new Product(
                    "yeet2",
                    2,
                    "medium"

            );

            repository.saveAll(
                    List.of(product1,product2)
            );
        };


    }
}
