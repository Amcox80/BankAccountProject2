package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ImportXMLFile {

    public String xmlFileContents(String filePath) {
        String contentsOfFile = "";
        try {
        if (filePath == null) {
            System.out.println("Invalid Input");
            throw new IOException();
        }
            File file = new File(filePath);
            FileInputStream fileInputStream;

                fileInputStream = new FileInputStream(file);
                contentsOfFile = new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8);

         } catch (IOException exception) {
               System.out.println("error " + exception.getMessage());
        }
            return contentsOfFile;
        }
    }