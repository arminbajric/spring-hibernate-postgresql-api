package rest.example.demo.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.example.demo.TableModels.category;
import rest.example.demo.TableModels.items;
import rest.example.demo.TableRepositories.CategoryRepository;
import rest.example.demo.TableRepositories.ItemsRepository;
import rest.example.demo.services.ItemsService;

import java.util.List;
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private final ItemsRepository itemsRepository;
    private final CategoryRepository categoryRepository;

    public ItemsServiceImpl(ItemsRepository itemsRepository, CategoryRepository categoryRepository) {
        this.itemsRepository = itemsRepository;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public List<items> findAllByCategory(String cat) {
      return null;
    }

    @Override
    public void editItem(items item) {

    }

    @Override
    public void deleteItem(Long item_id) {
    itemsRepository.deleteByItemsId(item_id);
    }

    @Override
    public items getItem(Long item_id) {
        return itemsRepository.findByItemsId(item_id);
    }



    @Override
    public List<items> getItem(String item_name) {
        return itemsRepository.findByItemNameIsLike(item_name);
    }

    @Override
    public void addItem(items item) {
        itemsRepository.save(item);
    }
}
