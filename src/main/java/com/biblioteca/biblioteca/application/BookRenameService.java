package com.biblioteca.biblioteca.application;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.adapters.BookRenameGateway;
import com.biblioteca.biblioteca.core.BookRenameUseCase;

@Service
public class BookRenameService implements BookRenameUseCase {

    BookRenameGateway bookRenameGateway;

    @Autowired
    BookRenameService(BookRenameGateway bookRenameGateway) {
        this.bookRenameGateway = bookRenameGateway;
    }

    @Override
    public Map<String, String> rename(int id, String name, String location) {
        return this.bookRenameGateway.rename(id, name, location);
    }

}
