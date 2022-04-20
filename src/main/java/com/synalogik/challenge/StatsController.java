package com.synalogik.challenge;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class StatsController {

    private final FileParser fileParser;
    private final StatService service;

    public StatsController(FileParser fileParser, StatService service) {
        this.fileParser = fileParser;
        this.service = service;
    }

    @PostMapping(path ="/wordStats", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getWordStats(@RequestBody MultipartFile file) throws IOException {
        if(file.isEmpty()){
            throw new FileNotFoundException("No file found!");
        }
        String string = fileParser.getFileContents(file);
        return buildWordStats(string).toString();
    }

    public Stats buildWordStats(String s) {
        return new Stats.Builder()
                .wordCount(service.returnWordCount(s))
                .averageWordLength(service.returnAverageWordLength(s))
                .numberOfWordsOfLength(service.returnNumberOfWordsOfLength(s))
                .mostFrequentlyOccurring(service.returnMostFrequentlyOccurringWordLength(s))
                .build();
    }
}