package rest.example.demo.TableRepositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import rest.example.demo.TableModels.category;
import rest.example.demo.TableModels.items;

import java.util.List;
@Repository
public interface ItemsRepository extends CrudRepository<items,Long> {

    void deleteByItemsId(Long item_id);
    items findByItemsId(Long id);

    List<items> findByItemNameStartingWith( String itemName);

    @Query("select i from items i where i.itemCode=?1")
   List<items> findByItemCode( int item_code);

    @Query("select i from items i where i.itemName=:itemName")
    items findByItemName(@Param("itemName") String item_name);

    @Query("update items set itemCode=:itemCode, itemName=:itemName,itemDescription=:itemDescription,itemPrice=:itemPrice,categoryId=:categoryId")
    void updateItem(@Param("itemCode")int itemCode,@Param("itemName") String itemName,@Param("itemDescription")String itemDescription,@Param("itemPrice")double itemPrice,@Param("categoryId")int categoryId);

}
