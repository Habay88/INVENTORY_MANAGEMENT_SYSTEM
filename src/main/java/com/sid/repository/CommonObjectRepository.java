package com.sid.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.CommonObject;

import java.util.List;

@Repository
public interface CommonObjectRepository extends JpaRepository<CommonObject, Long> {
    List<CommonObject> findByObjectType(String objectName);
}
