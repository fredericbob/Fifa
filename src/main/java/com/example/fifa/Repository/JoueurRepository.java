package com.example.fifa.Repository;

import com.example.fifa.Models.Joueurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueurs,Integer> {
}
