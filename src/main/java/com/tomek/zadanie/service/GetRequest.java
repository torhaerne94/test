package com.tomek.zadanie.service;

import com.tomek.zadanie.pojo.Post;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetRequest {

    public Post method(String urlToRead) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject(urlToRead ,Post.class);
    }
}
