package dev.noah.BookManager.api;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.noah.BookManager.model.Book;
import dev.noah.BookManager.utils.Query;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GoogleBooksAPI {

    private static RestTemplate restTemplate = new RestTemplate();

    public static String getBooks(String query, String title, String author, String subject) throws IOException {
        String urlString = "https://www.googleapis.com/books/v1/volumes";
        Map map = new HashMap<String, String>();
        map.put("query", query);
        map.put("title", title);
        map.put("author", author);
        map.put("subject", subject);
        String finalUrl = Query.build(urlString, map);
        URL url = new URL(finalUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        InputStreamReader charInput = new InputStreamReader(con.getInputStream());
        BufferedReader reader = new BufferedReader(charInput);
        StringBuilder response = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
}
