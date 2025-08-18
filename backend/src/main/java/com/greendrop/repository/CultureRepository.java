package com.greendrop.repository;
import com.greendrop.model.Culture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CultureRepository extends JpaRepository<Culture, Long> {
}
