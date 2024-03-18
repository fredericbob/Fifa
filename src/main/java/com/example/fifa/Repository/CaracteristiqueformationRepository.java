package com.example.fifa.Repository;

import com.example.fifa.Models.Caracteristiqueformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristiqueformationRepository extends JpaRepository<Caracteristiqueformation,Integer> {
}
