package com.example.fifa.Repository;

import com.example.fifa.Models.Caracteristique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristiqueRepository extends JpaRepository<Caracteristique,Integer> {

    @Query(value = "SELECT c FROM Caracteristique c where c.abreviation = :abreviation")
    Caracteristique getbycaracteristique(@Param("abreviation") String abreviation);
}
