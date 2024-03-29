package com.biblioteca.biblioteca.infra.file;

import java.io.FileWriter;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.core.exceptions.BookServiceException;

@Service
public class FileWriterProvider {
    final String ARQUIVO = new String("C:\\Users\\Luan\\src\\biblioteca\\books.json");

    public void create(JSONArray jsonArray) {
        try {

            FileWriter fileWriter = new FileWriter(ARQUIVO);
            fileWriter.write(jsonArray.toString());
            fileWriter.flush();
            fileWriter.close();

        } catch (Exception exception) {
            throw new BookServiceException("Failure while creating book", exception);
        }
    }
}
