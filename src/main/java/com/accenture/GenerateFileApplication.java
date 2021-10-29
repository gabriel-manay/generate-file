package com.accenture;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

@SpringBootApplication
public class GenerateFileApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(GenerateFileApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GenerateFileApplication.class, args);
	}

	@Bean
	public Consumer<Message<String>> generateFile() {
		
		return message ->
			logger.info("Se recibe transaccion: " + message.getPayload());
	}
	
}
