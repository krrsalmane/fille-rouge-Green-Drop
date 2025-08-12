package com.greendrop.repository;

import com.greendrop.model.Agriculteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgriculteurRepository extends JpaRepository<Agriculteur, Long> {
}