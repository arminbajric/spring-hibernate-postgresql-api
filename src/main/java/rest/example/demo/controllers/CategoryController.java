package rest.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rest.example.demo.TableModels.category;
import rest.example.demo.TableRepositories.CategoryRepository;

@RestController
public class CategoryController {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @RequestMapping(value="admin/add-category",method = RequestMethod.POST)
    public ResponseEntity addCategory(@RequestParam(name = "category")String cat){
        category category=new category(cat,0);

        categoryRepository.save(category);
        return ResponseEntity.status(201).build();
    }
}
