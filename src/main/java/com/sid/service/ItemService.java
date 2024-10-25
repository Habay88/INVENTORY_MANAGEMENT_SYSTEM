package com.sid.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.model.Item;
import com.sid.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }
}