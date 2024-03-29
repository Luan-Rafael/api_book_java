package com.biblioteca.biblioteca.adapters;

import java.util.Map;

public interface BookRenameGateway {
    Map<String, String> rename(int id, String name, String location);
}
