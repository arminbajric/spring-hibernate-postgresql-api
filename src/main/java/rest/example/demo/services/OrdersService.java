package rest.example.demo.services;

import rest.example.demo.TableModels.orders;
import rest.example.demo.TableModels.users;

import java.util.List;

public interface OrdersService {

  List<orders> getUserOrders(String email);

}
