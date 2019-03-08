package rest.example.demo.TableRepositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.example.demo.TableModels.users;
import rest.example.demo.TableModels.orders;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<orders,Long> {
    List<orders> getAllByUser(users user);
    List<orders> findAllByUser(users users);
}
