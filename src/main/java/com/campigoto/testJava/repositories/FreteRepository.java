package com.campigoto.testJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campigoto.testJava.entities.Frete;

@Repository 
public interface FreteRepository extends JpaRepository<Frete, Long> {

}
