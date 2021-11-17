package com.accenture;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

import com.accenture.model.Transaction;
import com.accenture.service.GenerateFileService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

@SpringBootApplication
public class GenerateFileApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(GenerateFileApplication.class);

	@Autowired
	GenerateFileService service;

	public static void main(String[] args) {
		SpringApplication.run(GenerateFileApplication.class, args);

	}

	@Bean
	public Consumer<Message<Transaction>> generateFile() {
		//ArrayList<String> mensajes=  new ArrayList<>();
		return message ->{
			Transaction transaction = (Transaction) message.getPayload();
			if(Objects.equals(transaction.getTransactionCode(), "AA")){
				service.creatingFile();
				}
			logger.info("Se recibe transaccion: " + message.getPayload());
			};
		};
}
