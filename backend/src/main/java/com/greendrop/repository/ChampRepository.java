package com.greendrop.repository;
import com.greendrop.model.Champ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChampRepository extends JpaRepository<Champ, Long> {
}
