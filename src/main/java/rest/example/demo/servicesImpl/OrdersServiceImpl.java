package rest.example.demo.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.example.demo.TableModels.orders;
import rest.example.demo.TableModels.users;
import rest.example.demo.TableRepositories.OrdersRepository;
import rest.example.demo.TableRepositories.UsersRepository;
import rest.example.demo.services.OrdersService;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private final OrdersRepository ordersRepository;
    private final UsersRepository usersRepository;
    public OrdersServiceImpl(OrdersRepository ordersRepository, UsersRepository usersRepository) {
        this.ordersRepository = ordersRepository;
        this.usersRepository = usersRepository;
    }


    @Override
    public List<orders> getUserOrders(String email) {
        users user=usersRepository.findByEmail(email);
        return null;
    }
}
