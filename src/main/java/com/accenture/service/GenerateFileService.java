package com.accenture.service;

import com.accenture.model.Bines052;
import com.accenture.model.Transaction;
import com.accenture.repository.Bines052Repository;
import com.accenture.repository.TransactionRepository;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateFileService {
    @Value("${application.bucket.name}")
    private String bucketName;

    @Value("${application.file.name}")
    private String fileName;

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
    private Bines052Repository repository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void creatingFile(){
        List<Transaction> list = transactionRepository.findAll();

        File fout = new File("Data2.txt");
        try (FileOutputStream fos = new FileOutputStream(fout);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
            for (Transaction message : list) {
                bw.write(message.toString());
                bw.newLine();
            }
            bw.close();
            s3Client.putObject(bucketName, fileName, fout);
        } catch (IOException ignored) {
        }
    }

    /*public void creatingFile() {

      ArrayList<String> mensajes = new ArrayList();
        mensajes.add("Linea 1");
        mensajes.add("Linea 2");
        mensajes.add("Linea 3");
        mensajes.add("Linea 4");
        mensajes.add("Linea 5");
        mensajes.add("Linea 6");
        mensajes.add("Linea 7");

        File fout = new File("Data2.txt");
        try (FileOutputStream fos = new FileOutputStream(fout);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
            for (String message : mensajes) {
                bw.write(message);
                bw.newLine();
            }
            bw.close();
            s3Client.putObject(bucketName, fileName, fout);
        } catch (IOException ignored) {
        }
    }*/

}
