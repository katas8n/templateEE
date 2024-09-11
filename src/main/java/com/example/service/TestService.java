package com.example.service;

import java.util.HashMap;
import java.util.Map;

public class TestService {

    public Map<String, Object> getTestData() {
        Map<String, Object> dataModel = new HashMap<>();
        // Add sample data to the model
        dataModel.put("message", "Hello, FreeMarker!");
        dataModel.put("items", new String[]{"Item 1", "Item 2", "Item 3"});
        return dataModel;
    }
}
