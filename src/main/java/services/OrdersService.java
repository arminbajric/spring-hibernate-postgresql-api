package services;

import org.springframework.stereotype.Service;
import rest.example.demo.models.User;
import rest.example.demo.models.orders;
import rest.example.demo.repositories.OrdersRepository;

import java.util.List;

public interface OrdersService {
List<orders> getAllOrdersByUser(User user);
orders getOrderDetails(orders orders);

}
