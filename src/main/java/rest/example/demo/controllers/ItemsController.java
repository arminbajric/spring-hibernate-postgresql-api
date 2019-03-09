package rest.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.example.demo.TableModels.category;
import rest.example.demo.TableModels.items;
import rest.example.demo.TableRepositories.CategoryRepository;
import rest.example.demo.services.ItemsService;

@RestController
public class ItemsController {
    @Autowired
    private final ItemsService itemsService;
    private final CategoryRepository categoryRepository;
    public ItemsController(ItemsService itemsService, CategoryRepository categoryRepository) {
        this.itemsService = itemsService;
        this.categoryRepository = categoryRepository;
    }
    @RequestMapping(value="{category}/items",method = RequestMethod.GET)
    public ResponseEntity getItemsByCategory(@PathVariable(name = "category") String category)
    {
        return ResponseEntity.ok().body(itemsService.findAllByCategory(category));
    }
    @RequestMapping(value="admin/add-item",method = RequestMethod.POST)
    public ResponseEntity addItem(@RequestBody items item)
    {
        category cat=categoryRepository.getOne(item.getCategory().getCategoryId());
        item.setCategoryId(cat);
        itemsService.addItem(item);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "admin/edit-item",method = RequestMethod.POST)
    public ResponseEntity editItem(@RequestParam(name="code")String item_code,@RequestBody items item)
    {

        return ResponseEntity.ok().build();
    }
    @RequestMapping(value="admin/delete-item",method = RequestMethod.POST)
    public ResponseEntity deleteItem(@RequestParam(name="item-code")Long item_code)
    {
        itemsService.deleteItem(item_code);
        return ResponseEntity.ok().build();
    }
}
