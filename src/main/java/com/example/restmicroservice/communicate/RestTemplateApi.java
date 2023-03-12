package com.example.restmicroservice.communicate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestTemplateApi {

    private static final RestTemplate restTemplate = new RestTemplate();


    public static void main(String[] args) {

        System.out.println(getMethod());
    }

    public static ResponseEntity<ArrayList> getMethod() {
        ResponseEntity<ArrayList> forEntity = restTemplate.getForEntity("http://localhost:8081/api/getAllUsers", ArrayList.class);
        return forEntity;
    }


    public static void postMethod() {
        UserCopy user = new UserCopy(44, 2, "Oleg", 178);

        HttpEntity<UserCopy> httpEntity = new HttpEntity<>(user);

        restTemplate.postForEntity("http://localhost:8081/api/saveUser", httpEntity, UserCopy.class);

    }


    public static void deleteUser(String name) {

        Map<String, String> map = new HashMap<>();
        map.put("name", name);

        restTemplate.delete("http://localhost:8081/api/byName/" + name, map);

    }


    public static void updateUser(int id, UserCopy user) {
        HttpEntity<UserCopy> httpEntity = new HttpEntity<>(user);
        restTemplate.put("http://localhost:8081/api/updateUser/" + id, httpEntity);

    }


}
