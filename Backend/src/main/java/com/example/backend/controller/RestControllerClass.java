package com.example.backend.controller;
import com.example.backend.service.Service;
import com.example.backend.service.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestControllerClass {

    private final Service service;

    @GetMapping("/getAllUsers")
    public List<User> list() {
        return service.getAllUsers();
    }


    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user) {
        service.saveUser(user);
    }


    @DeleteMapping("/byName/{name}")
    public void deleteUser(@PathVariable("name") String name) {
        service.deleteUser(name);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") int id, @RequestBody User user) {
        service.update(id, user);
        return ResponseEntity.ok(user);
    }
}
