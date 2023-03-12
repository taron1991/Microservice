package com.example.backend.service;

import com.example.backend.exception.PersonNotFoundException;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Component
public class Service {

    private List<User> users = new ArrayList<>();

    {
        users.add(new User(43, 1, "Igor", 187));
        users.add(new User(31, 2, "Ivan", 172));
        users.add(new User(19, 5, "Nikolay", 176));
        users.add(new User(23, 4, "Maria", 170));
    }


    public List<User> getAllUsers() {
        return users;
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public void deleteUser(String name) {

        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().equals(name)) {
                iterator.remove();
                break;
            }
            if (!iterator.hasNext()) {
                throw new PersonNotFoundException("person not found " + name);
            }
        }

    }

    public void update(int id, User user) {

        int count = 0;
        for (User user1 : users) {
            count++;
            if (user1.getId().equals(id)) {
                user1.setAge(user.getAge());
                user1.setName(user.getName());
                user1.setHeight(user.getHeight());
                break;
            }
            if (count == users.size()) {
                throw new PersonNotFoundException("person not found with such an id" + id);
            }
        }


    }
}
