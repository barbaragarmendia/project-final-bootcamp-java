package com.projectfinalbootcampjava.domain.repository;

import com.projectfinalbootcampjava.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
