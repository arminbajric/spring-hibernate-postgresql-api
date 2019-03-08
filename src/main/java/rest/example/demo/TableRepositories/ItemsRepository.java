package rest.example.demo.TableRepositories;

import org.springframework.data.repository.CrudRepository;
import rest.example.demo.TableModels.items;

public interface ItemsRepository extends CrudRepository<items,Long> {


}
