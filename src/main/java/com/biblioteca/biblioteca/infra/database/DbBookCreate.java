package com.biblioteca.biblioteca.infra.database;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.adapters.BookCreateGateway;
import com.biblioteca.biblioteca.core.exceptions.BookServiceException;
import com.biblioteca.biblioteca.infra.file.FileReaderProvider;
import com.biblioteca.biblioteca.infra.file.FileWriterProvider;

@Service
public class DbBookCreate implements BookCreateGateway {

    final FileReaderProvider fileReaderProvider;
    final FileWriterProvider fileWriterProvider;

    @Autowired
    DbBookCreate(FileReaderProvider fileReaderProvider, FileWriterProvider fileWriterProvider) {
        this.fileReaderProvider = fileReaderProvider;
        this.fileWriterProvider = fileWriterProvider;
    }

    @Override
    public void bookCreate(String name, String location) {
        try {

            JSONArray array = this.fileReaderProvider.find();

            JSONObject object = new JSONObject();

            object.put("id", array.length() + 1);
            object.put("name", name);
            object.put("location", location);

            array.put(object);

            this.fileWriterProvider.create(array);

        } catch (Exception exception) {
            throw new BookServiceException("Failure while creating book", exception);
        }
    }
}
