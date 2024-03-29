package com.biblioteca.biblioteca.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.core.BookCreateUseCase;
import com.biblioteca.biblioteca.adapters.BookCreateGateway;

@Service
public class BookCreateService implements BookCreateUseCase {

    private final BookCreateGateway bookCreateGateway;

    @Autowired
    public BookCreateService(BookCreateGateway bookGateway) {
        this.bookCreateGateway = bookGateway;
    }

    @Override
    public void create(String name, String location) {
        this.bookCreateGateway.bookCreate(name, location);
    }

}
