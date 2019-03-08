package rest.example.demo.services;

import rest.example.demo.TableModels.items;

import java.util.List;

public interface ItemsService {
    List<items> findAllByCategory(String category);
    void editItem(items item);
    void deleteItem(Long item_id);
    items getItem(Long item_id);
    List<items> getItem(String item_name);
    void addItem(items item);
}
