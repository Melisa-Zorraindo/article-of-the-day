package com.melisazor.article_of_the_day.services;

import com.melisazor.article_of_the_day.models.NytResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArticleService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${NYT_API_KEY}")
    private String nytApiKey;

    public ArticleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NytResponse getArticles(String topic) {
        String partialUrl = "https://api.nytimes.com/svc/topstories/v2/%s.json?api-key=%s";
        String apiUrl = String.format(partialUrl, topic, nytApiKey);

        ResponseEntity<NytResponse> exchange = restTemplate
                .exchange(apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        return exchange.getBody();
    }
}
