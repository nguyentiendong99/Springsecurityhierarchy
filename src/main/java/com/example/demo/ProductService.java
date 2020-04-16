package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public List<Product> list(){
        return (List<Product>) repository.findAll();
    }
    public void save(Product product){
        repository.save(product);
    }
    public Product get(Long id){
        return repository.findById(id).get();
    }
    public void delete(long id){
        repository.deleteById(id);
    }
    public List<Product> search(String keyword){
        return repository.findByName(keyword);
    }
}
