package rest.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.example.demo.TableModels.order_details;
import rest.example.demo.TableModels.orders;
import rest.example.demo.TableModels.users;
import rest.example.demo.TableRepositories.OrdersRepository;
import rest.example.demo.services.ItemsService;
import rest.example.demo.services.OrderDetailsService;
import rest.example.demo.services.OrdersService;
import rest.example.demo.services.UserService;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private final OrdersService ordersService;
    private final UserService userService;
    private final ItemsService itemsService;
    private final OrdersRepository ordersRepository;
    private final OrderDetailsService orderDetailsService;


    public OrdersController(OrdersService ordersService, UserService userService, ItemsService itemsService, OrdersRepository ordersRepository, OrderDetailsService orderDetailsService) {
        this.ordersService = ordersService;
        this.userService = userService;
        this.itemsService = itemsService;
        this.ordersRepository = ordersRepository;
        this.orderDetailsService = orderDetailsService;
    }
    @RequestMapping(value="user/create-order",method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestParam(name = "email") String email, @RequestBody List<order_details> order_details)
    {
        users u=userService.getUser(email);
        orders o=new orders();

      o.setOrder_details(order_details);
        o.setOrderDate(new java.util.Date());
        o.setUser(u);
        ordersRepository.save(o);
        for(int i=0;i<order_details.size();i++)
        {
            rest.example.demo.TableModels.order_details order_details1=order_details.get(i);
            order_details1.setOrders(o);
            orderDetailsService.saveOrderDetails(order_details1);
        }
      return  ResponseEntity.ok().build();

    }
}
