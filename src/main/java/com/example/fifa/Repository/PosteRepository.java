package com.example.fifa.Repository;

import com.example.fifa.Models.Coefficient;
import com.example.fifa.Models.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepository extends JpaRepository<Poste,Integer> {

    @Query(value = "SELECT c FROM Poste c where c.nom =:poste")
    Poste getbyposte(@Param("poste") String poste);
}
