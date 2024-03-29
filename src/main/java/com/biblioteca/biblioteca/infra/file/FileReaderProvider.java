package com.biblioteca.biblioteca.infra.file;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.core.exceptions.BookServiceException;

@Service
public class FileReaderProvider {
    final String ARQUIVO = new String("C:\\Users\\Luan\\src\\biblioteca\\books.json");

    public JSONArray find() {
        try {

            FileReader fileReader = new FileReader(ARQUIVO);

            JSONTokener jsonTokener = new JSONTokener(fileReader);

            JSONArray jsonArray = new JSONArray(jsonTokener);

           
            return jsonArray;

        } catch (Exception exception) {
            throw new BookServiceException("Failure while reading book", exception);
        }
    }
}
