package com.example.demo.Services;

import com.example.demo.Models.Product;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private int index = 0;

    @Autowired
    private ProductRepository repository;


    public List<Product> getAll(){
        return new ArrayList<>(repository.getAll());
    }

    public boolean switchIsDone(int id){
        return repository.switchIsDone(id);
    }

    public Product add(String label){
        Product res = new Product(++index, label, false);
        repository.add(res);
        return res;
    }

    public void remove(int id){
        repository.remove(id);
    }
}
