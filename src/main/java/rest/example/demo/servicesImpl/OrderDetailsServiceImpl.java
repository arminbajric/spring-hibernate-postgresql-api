package rest.example.demo.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.example.demo.TableModels.order_details;
import rest.example.demo.TableRepositories.OrderDetailsRepository;
import rest.example.demo.services.OrderDetailsService;
@Service
public class OrderDetailsServiceImpl  implements OrderDetailsService {
    @Autowired
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public void saveOrderDetails(order_details order_details) {
        orderDetailsRepository.save(order_details);
    }
}
