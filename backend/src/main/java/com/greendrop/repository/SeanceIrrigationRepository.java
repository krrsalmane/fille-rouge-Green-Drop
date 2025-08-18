package com.greendrop.repository;
import com.greendrop.model.SeanceIrrigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceIrrigationRepository extends JpaRepository<SeanceIrrigation, Long> {
}
