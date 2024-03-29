package com.biblioteca.biblioteca.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.application.BookCreateService;
import com.biblioteca.biblioteca.core.BookRequest;
import com.biblioteca.biblioteca.core.exceptions.BookServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping
public class BookCreateController {

    private final BookCreateService bookCreateService;

    @Autowired
    public BookCreateController(BookCreateService bookService) {
        this.bookCreateService = bookService;
    }

    @PostMapping
    public ResponseEntity<String> bookCreate(@RequestBody BookRequest request) {
        try {

            this.bookCreateService.create(request.name(), request.location());

            return ResponseEntity.ok("book created successfully");
        } catch (BookServiceException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getCause().toString());
        }

    }

}