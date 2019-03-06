package services;

import rest.example.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void  create(User user);
}
