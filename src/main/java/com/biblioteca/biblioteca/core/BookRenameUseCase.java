package com.biblioteca.biblioteca.core;

import java.util.Map;

public interface BookRenameUseCase {
    Map<String, String> rename(int id, String name, String location);
}
