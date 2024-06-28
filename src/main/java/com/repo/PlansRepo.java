package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.PlansEntity;

@Repository
public interface PlansRepo extends JpaRepository<PlansEntity, Integer> {

}
