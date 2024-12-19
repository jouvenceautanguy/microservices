package com.example.student.service;

import com.example.student.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    public School getPost(Long id) {
        String url = "http://SCHOOL/api/schools/" + id;
        return restTemplate.getForObject(url, School.class);
    }
}
