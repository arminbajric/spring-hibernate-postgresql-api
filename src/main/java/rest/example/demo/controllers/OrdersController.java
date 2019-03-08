package rest.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.example.demo.Models.userOrder;
import rest.example.demo.services.OrdersService;

@RestController
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
    @RequestMapping(value="user/create-order",method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestParam String user_email, @RequestBody userOrder userOrder)
    {
      return null;
    }
}
