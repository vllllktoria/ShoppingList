package com.example.demo.Repositories;

import com.example.demo.Models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    private final Map<Integer, Product> entryMap = new HashMap<>();

    public void add(Product todo){
        entryMap.put(todo.getId(), todo);
    }

    public Collection<Product> getAll(){
        return entryMap.values();
    }

    public boolean switchIsDone(Integer id){
        return entryMap.get(id).switchIsDone();
    }

    public void remove(int id){
        entryMap.remove(id);
    }
}
