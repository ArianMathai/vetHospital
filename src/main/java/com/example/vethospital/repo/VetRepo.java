package com.example.vethospital.repo;

import com.example.vethospital.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepo extends JpaRepository<Vet,Long> {
}
