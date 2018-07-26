package com.citi.test.csi.connection;

import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("/spring-gemfire-cache-server-context.xml")
public class Application {
	
    public static void main(final String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }

    
    @Bean
    ApplicationRunner run(final CsiRepository csiRepository) {
    	    	
        return args -> {
        	
        	final Iterable<Csi> person = csiRepository.findAll();
        	
        	final Iterator<Csi> iterator = person.iterator();
        	
        	while(iterator.hasNext()) {
        		System.out.println(":: CSI Iterable: " + iterator.next());
        	}
        	
        	// Get the CSI with the IdCustomer
        	final Optional<Csi> csi = csiRepository.findById("2");
        	
        	System.out.println(":: CSI by Id: " + csi.get());
        	
        };
    }
}
