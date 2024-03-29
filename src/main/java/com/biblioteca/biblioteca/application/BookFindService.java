package com.biblioteca.biblioteca.application;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.adapters.BookFindGateway;
import com.biblioteca.biblioteca.core.BookFindUseCase;

@Service
public class BookFindService implements BookFindUseCase {

    private final BookFindGateway bookFindGateway;

    @Autowired
    public BookFindService(BookFindGateway bookFindGateway) {
        this.bookFindGateway = bookFindGateway;
    }

    @Override
    public ArrayList<Map<String, String>> find() {
        return this.bookFindGateway.find();
    }

}
