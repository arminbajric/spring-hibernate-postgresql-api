package rest.example.demo.TableRepositories;

import org.springframework.data.repository.CrudRepository;
import rest.example.demo.TableModels.category;
import rest.example.demo.TableModels.items;

import java.util.List;

public interface ItemsRepository extends CrudRepository<items,Long> {

    void deleteByItemsId(Long item_id);
    items findByItemsId(Long id);
    List<items> findByItemNameIsLike(String item_name);
   List<items> findByItemCode(String item_code);
    items findByItemName(String item_name);
}
