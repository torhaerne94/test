package com.tomek.zadanie.service;

import com.tomek.zadanie.dto.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

@Component
public class PostService {

    private @Value("${post.address}")
    String postAddress;

    @SuppressWarnings("unused")
    public Post getPost(String id) throws HttpClientErrorException, HttpServerErrorException, UnknownHttpStatusCodeException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject((postAddress + id), Post.class);
    }
}
