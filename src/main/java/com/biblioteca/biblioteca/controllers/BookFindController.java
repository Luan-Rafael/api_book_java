package com.biblioteca.biblioteca.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.application.BookFindService;
import com.biblioteca.biblioteca.core.exceptions.BookServiceException;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping
public class BookFindController {
    private final BookFindService bookFindService;

    @Autowired
    public BookFindController(BookFindService bookFindService) {
        this.bookFindService = bookFindService;

    }

    @GetMapping
    public ResponseEntity<ArrayList<Map<String, String>>> find() {
        try {
            ArrayList<Map<String, String>> data = new ArrayList<>();
            data = this.bookFindService.find();
            return ResponseEntity.ok(data);

        } catch (BookServiceException exception) {
            Map<String, String> map = Map.of("error", exception.getCause().toString());
            ArrayList<Map<String, String>> array = new ArrayList<>();
            array.add(map);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(array);

        }
    }

}
