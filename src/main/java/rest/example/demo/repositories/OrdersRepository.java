package rest.example.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.example.demo.models.User;
import rest.example.demo.models.orders;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<orders,Long> {
    List<orders> getAllByUser(User user);
    orders getByOrders_id(int order_id);
}
