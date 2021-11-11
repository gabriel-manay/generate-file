package com.accenture.service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;

@Service
public class GenerateFileService {
    @Value("${application.bucket.name}")
    private String bucketName;

    @Value("${application.file.name}")
    private String fileName;

    @Autowired
    private AmazonS3 s3Client;

    public void creatingFile() {

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
    }

}
