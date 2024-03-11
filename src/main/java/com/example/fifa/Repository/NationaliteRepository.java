package com.example.fifa.Repository;

import com.example.fifa.Models.Nationalite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite,Integer> {

    @Modifying
    @Query(value = "UPDATE Nationalite n set n.nom = :nom WHERE n.id= :id")
    void uptade(@Param("id") int id ,@Param("nom") String nom);
}
