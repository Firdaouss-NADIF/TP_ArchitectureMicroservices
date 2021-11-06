package com.enset.customerservice;

import com.enset.customerservice.dto.CustomerRequestDTO;
import com.enset.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerService customerService) {
        return args -> {
          customerService.save(new CustomerRequestDTO("C01","Firdaouss","Firdaouss@gmail.com"));
          customerService.save(new CustomerRequestDTO("C02","Nadif","Nadif@gmail.com"));
          customerService.save(new CustomerRequestDTO("C03","FirdaoussNadif","FirdaoussNadif@gmail.com"));

        };
    }

}
