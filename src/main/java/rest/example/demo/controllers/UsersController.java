package rest.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.example.demo.models.User;
import services.UserService;

@RestController
public class UsersController {
    @Autowired
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value="/",method = RequestMethod.GET)
    public ResponseEntity getUsers(){
        return ResponseEntity.ok().body(userService.getAll());
    }
    @RequestMapping(method = RequestMethod.POST,value = "/addUser")
    public ResponseEntity addUser(@RequestBody User u){

        userService.create(u);
        return ResponseEntity.ok().body(u);
    }
}
