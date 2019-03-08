package rest.example.demo.services;

import rest.example.demo.Models.user;
import rest.example.demo.TableModels.users;

import java.util.List;

public interface UserService {
    public List<users> getAll();
    public  void  create(users user);
   public users checkUserForLogin(String email, String password);
}
