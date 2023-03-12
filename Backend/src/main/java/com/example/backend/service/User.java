package com.example.backend.service;



import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {

    private int age;
    private Integer id;
    private String name;
    private double height;
}
