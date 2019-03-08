package rest.example.demo.TableRepositories;

import org.springframework.data.repository.CrudRepository;
import rest.example.demo.TableModels.order_details;

public interface OrderDetailsRepository extends CrudRepository<order_details,Long> {

}
