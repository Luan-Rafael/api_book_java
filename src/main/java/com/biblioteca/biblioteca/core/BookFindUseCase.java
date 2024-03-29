package com.biblioteca.biblioteca.core;

import java.util.ArrayList;
import java.util.Map;

public interface BookFindUseCase {
    ArrayList<Map<String, String>> find();
}