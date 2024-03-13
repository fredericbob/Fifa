package com.example.fifa.Repository;

import com.example.fifa.Models.Club;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club,Integer> {

    @Query(value ="SELECT c FROM Club c where c.code_club = :club")
     Club getBycode(@Param("club") String club);
}
