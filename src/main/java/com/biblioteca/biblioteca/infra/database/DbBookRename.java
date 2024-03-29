package com.biblioteca.biblioteca.infra.database;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.adapters.BookRenameGateway;
import com.biblioteca.biblioteca.core.exceptions.BookServiceException;
import com.biblioteca.biblioteca.infra.file.FileReaderProvider;
import com.biblioteca.biblioteca.infra.file.FileWriterProvider;

@Service
public class DbBookRename implements BookRenameGateway {
    final FileReaderProvider fileReaderProvider;
    final FileWriterProvider fileWriterProvider;

    @Autowired
    DbBookRename(FileReaderProvider fileReaderProvider, FileWriterProvider fileWriterProvider) {
        this.fileReaderProvider = fileReaderProvider;
        this.fileWriterProvider = fileWriterProvider;

    }

    @Override
    public Map<String, String> rename(int id, String name, String location) {
        try {
            Map<String, String> objectRename = new HashMap<String, String>();
            objectRename.put("id", Integer.toString(id));
            objectRename.put("name", name);
            objectRename.put("location", location);

            JSONArray array = this.fileReaderProvider.find();

            for (int index = 0; index < array.length(); index++) {
                JSONObject object = array.getJSONObject(index);
                int idObject = object.getInt("id");
                if (idObject == id) {
                    array.put(index, objectRename);
                    break;
                }
            }
            this.fileWriterProvider.create(array);
            return objectRename;
        } catch (Exception exception) {
            throw new BookServiceException("Failure while rename book", exception);
        }
    }
}
