package rest.example.demo.TableRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.example.demo.TableModels.order_details;
@Repository
public interface OrderDetailsRepository extends CrudRepository<order_details,Long> {

}
