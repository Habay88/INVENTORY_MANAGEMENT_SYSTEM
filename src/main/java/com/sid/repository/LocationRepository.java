package com.sid.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
