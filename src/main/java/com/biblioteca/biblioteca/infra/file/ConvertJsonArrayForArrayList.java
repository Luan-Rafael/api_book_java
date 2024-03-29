package com.biblioteca.biblioteca.infra.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ConvertJsonArrayForArrayList {
    public ArrayList<Map<String, String>> convert(JSONArray jsonArray) {
        ArrayList<Map<String, String>> array = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            Map<String, String> bookMap = new HashMap<String, String>();
            JSONObject objectJson = jsonArray.getJSONObject(i);

            bookMap.put("id", Integer.toString(objectJson.getInt("id")));
            bookMap.put("name", objectJson.getString("name"));
            bookMap.put("location", objectJson.getString("location"));

            array.add(bookMap);
        }

        return array;

    }
}
