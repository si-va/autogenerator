package com.siva.inversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class InversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InversionApplication.class, args);


		List<String> strings = new ArrayList<>();
		strings.add("AMir");

		strings.add("Capitano");

		strings.add("Marco");
		strings.add("Sohail");
		strings.add("Marco");


		for(String a: strings){
			System.out.println(a);
		}


		Optional<String> marco = strings.stream().filter(item -> item.equalsIgnoreCase("Marco")).findFirst();

	}

}
