package com.example.fifa.Repository;

import com.example.fifa.Models.Nationalite;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite,Integer> {

    @Query(value = "SELECT n FROM Nationalite n where n.code = :code")
    Nationalite getbycode(@Param("code") String nationalite);

}
