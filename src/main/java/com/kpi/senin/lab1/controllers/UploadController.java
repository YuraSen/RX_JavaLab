package com.kpi.senin.lab1.controllers;

import com.kpi.senin.lab1.model.EntryModel;
import com.kpi.senin.lab1.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @GetMapping("/singleThread")
    public Map<String, ?> addEntries(@RequestParam("amount") int amount) {
        Map<String, Object> modelMap = new HashMap<>();
        List<EntryModel> entries = new ArrayList<>(amount);
        UUID uuid;
        for (int i = 0; i < amount; i++) {
            uuid = UUID.randomUUID();
            entries.add(new EntryModel(uuid.toString(), uuid.hashCode()));
        }
        uploadService.addEntries(entries);


        return modelMap;
    }
}