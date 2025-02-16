package dev.noah.BookManager.utils;

import java.util.Map;

public class Query {
    public static String build(String url, Map<String, String> map) {
        StringBuilder finalUrl = new StringBuilder(url);

        finalUrl.append("?q=");
        finalUrl.append(map.get("q"));

        if(map.containsKey("title")) {
            finalUrl.append("+intitle=");
            finalUrl.append(map.get("title"));
        }
        if(map.containsKey("author")) {
            finalUrl.append("+inauthor=");
            finalUrl.append(map.get("author"));
        }
        if(map.containsKey("subject")) {
            finalUrl.append("+subject=");
            finalUrl.append(map.get("subject"));
        }

        return finalUrl.toString();
    }
}
