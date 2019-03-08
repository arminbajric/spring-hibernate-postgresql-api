package rest.example.demo.controllers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.example.demo.Models.userInfo;
import rest.example.demo.TableModels.orders;
import rest.example.demo.TableModels.users;
import rest.example.demo.services.OrdersService;
import rest.example.demo.services.UserService;

import java.util.Date;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private final UserService userService;
    private final OrdersService ordersService;

    public UsersController(UserService userService, OrdersService ordersService) {

        this.userService = userService;
        this.ordersService = ordersService;
    }
    @RequestMapping(value="/signin",method = RequestMethod.POST)
    public ResponseEntity getUsers(@RequestParam(name = "email")String email,@RequestParam(name="password") String password){
        users user=userService.checkUserForLogin(email, password);
        System.out.println();
        userInfo userInfo=new userInfo();
        userInfo.setId(user.getId());
        userInfo.setUsername(user.getUsername());
        userInfo.setUser_email(user.getUser_email());
        userInfo.setDate_of_registration(user.getDate_of_registration());
            return ResponseEntity.ok().body( userInfo);



        }
    @RequestMapping(method = RequestMethod.POST,value = "/addUser")
    public ResponseEntity addUser(@RequestBody users u) {
        u.setDate_of_registration(new Date());
        try {
            userService.create(u);
            return ResponseEntity.ok().body(u);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }
    @RequestMapping(value = "/user/orders",method = RequestMethod.GET)
    public ResponseEntity getUserOrders(@RequestParam(name="email")String email){
        List<orders> userOrders=ordersService.getUserOrders(email);
        return ResponseEntity.status(201).body(userOrders);


    }
}
