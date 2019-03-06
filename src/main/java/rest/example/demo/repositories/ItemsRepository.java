package rest.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import rest.example.demo.models.items;

import java.util.List;

public interface ItemsRepository extends CrudRepository<items,Long> {
    List<items> getAllByItem_nameIsLike(String searchName);

}
