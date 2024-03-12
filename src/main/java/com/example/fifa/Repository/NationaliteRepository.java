package com.example.fifa.Repository;

import com.example.fifa.Models.Nationalite;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite,Integer> {


}
