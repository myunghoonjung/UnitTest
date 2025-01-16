package com.example.UnitTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ApiService {

    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts";
    private final ObjectMapper objectMapper;

    public ApiService() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Map<String, Object>> fetchPosts() throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            try (CloseableHttpResponse response = client.execute(request)) {
                if (response.getCode() == 200) {
                    return objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Map<String, Object>>>() {});
                } else {
                    throw new IOException("API 호출 실패 " + response.getCode());
                }
            }
        }
    }
}
