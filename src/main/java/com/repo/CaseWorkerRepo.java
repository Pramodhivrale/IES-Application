package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CaseWorkerEntity;

@Repository
public interface CaseWorkerRepo extends JpaRepository<CaseWorkerEntity, Integer> {

    public CaseWorkerEntity findByEmailId(String emailId);

}
