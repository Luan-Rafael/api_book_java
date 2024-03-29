package com.biblioteca.biblioteca.infra.database;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.adapters.BookFindGateway;
import com.biblioteca.biblioteca.core.exceptions.BookServiceException;
import com.biblioteca.biblioteca.infra.file.ConvertJsonArrayForArrayList;
import com.biblioteca.biblioteca.infra.file.FileReaderProvider;

@Service
public class DbBookFind implements BookFindGateway {
    final FileReaderProvider fileReaderProvider;
    final ConvertJsonArrayForArrayList convertJsonArrayForArrayList;

    @Autowired
    DbBookFind(FileReaderProvider fileReaderProvider, ConvertJsonArrayForArrayList convertJsonArrayForArrayList) {
        this.fileReaderProvider = fileReaderProvider;
        this.convertJsonArrayForArrayList = convertJsonArrayForArrayList;
    }

    @Override
    public ArrayList<Map<String, String>> find() {
        try {
            JSONArray array = this.fileReaderProvider.find();

            ArrayList<Map<String, String>> data = this.convertJsonArrayForArrayList.convert(array);

            return data;
        } catch (Exception exception) {
            throw new BookServiceException("Failure while reading book", exception);
        }
    }
}
