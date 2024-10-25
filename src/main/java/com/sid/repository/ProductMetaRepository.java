package com.sid.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.ProductMeta;

@Repository
public interface ProductMetaRepository extends JpaRepository<ProductMeta, Long> {
}
