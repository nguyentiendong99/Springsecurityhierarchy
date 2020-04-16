package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query(value = "SELECT c FROM Product c where c.name like '%' || :keyword || '%'" +
                   " or c.address like '%' || :keyword || '%'" +
                   " or c.email like '%' || :keyword || '%'" +
                   " or c.nameproduct like '%' || :keyword || '%'" +
                   "or c.price like '%' || :keyword || '%'")
    List<Product> findByName(@Param("keyword") String keyword);
}
