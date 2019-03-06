package rest.example.demo.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.example.demo.models.User;
import rest.example.demo.models.orders;
import rest.example.demo.repositories.OrdersRepository;
import services.OrdersService;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private final OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<orders> getAllOrdersByUser(User user) {
        return null;
    }

    @Override
    public orders getOrderDetails(orders orders) {
        return null;
    }
}
