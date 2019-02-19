package com.tomek.zadanie.service;

import com.tomek.zadanie.pojo.Post;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

@Component
public class GetRequest {

    public Post getPost(String urlToRead)throws HttpClientErrorException, HttpServerErrorException, UnknownHttpStatusCodeException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject(urlToRead ,Post.class);
    }
}
