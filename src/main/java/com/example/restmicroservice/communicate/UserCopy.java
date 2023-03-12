package com.example.restmicroservice.communicate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCopy {

    private int age;
    private int id;
    private String name;
    private double height;
}
