package com.synalogik.challenge;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Component
public class FileParser {

    public String getFileContents(MultipartFile file) throws IOException {

        InputStreamReader reader = new InputStreamReader(file.getInputStream());
        BufferedReader bReader = new BufferedReader(reader);
        StringBuffer sBuffer = new StringBuffer();
        String string;
        while((string = bReader.readLine()) != null) {
            sBuffer.append(string);
        }
        return sBuffer.toString();
    }
}
