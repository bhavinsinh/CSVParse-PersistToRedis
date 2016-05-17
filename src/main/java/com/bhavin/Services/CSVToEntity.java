package com.bhavin.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhavinchauhan on 5/17/16.
 */
@Service
public class CSVToEntity {


    public static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private CachingService cachingService;

    public CSVToEntity() {
    }

    public static String jsonEncode(Object o) throws JsonProcessingException {
        if (o == null)
            return "";
        return objectMapper.writeValueAsString(o);
    }

    public void write(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String delim = ",";
        try {
            br = new BufferedReader(new InputStreamReader(new URL(csvFile).openStream()));
            String headersLine = br.readLine();
            String[] headers = headersLine.split(delim);
            int j = 0;
            while ((line = br.readLine()) != null) {
                Map<String, String> maps = new HashMap<String, String>();
                int hashCode = 0;
                String[] tokens = line.split(delim);
                for (int i = 0; i < tokens.length; i++) {
                    maps.put(headers[i], tokens[i]);
                    String token = headers[i].toLowerCase().trim();
                    if (token.equals("trip date") || token.equals("route id")
                            || token.equals("trip no"))  {
                        if (tokens[i] != null) {
                            hashCode += tokens[i].hashCode();
                        }
                    }
                }
                cachingService.set(String.valueOf(hashCode), maps, 0);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String read(String tripDate, String tripId, String routeID) throws IOException {
        int hashCode = tripDate.hashCode() + tripId.hashCode() + routeID.hashCode();
        TypeReference<Map<String, String>> typeRef = new TypeReference<Map<String, String>>() {
        };
        return (cachingService.get(String.valueOf(hashCode), typeRef)).toString();
    }
}
