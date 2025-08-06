package com.greendrop.repository;
import com.greendrop.model.Champ;
import com.greendrop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChampRepository extends JpaRepository<Champ, Long> {

    List<Champ> findByAgriculteur(User agriculteur);
}
