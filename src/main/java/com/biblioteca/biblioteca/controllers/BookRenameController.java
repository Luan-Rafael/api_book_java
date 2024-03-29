package com.biblioteca.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.application.BookRenameService;
import com.biblioteca.biblioteca.core.BookRequest;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping
public class BookRenameController {
    private final BookRenameService bookRenameService;

    @Autowired
    BookRenameController(BookRenameService bookRenameService) {
        this.bookRenameService = bookRenameService;
    }

    @PutMapping
    public ResponseEntity<String> rename(@RequestParam("id") int id, @RequestBody BookRequest request) {
        try {
            this.bookRenameService.rename(id, request.name(), request.location());
            return ResponseEntity.ok("book renamed successfully");

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getCause().toString());

        }

    }

}
