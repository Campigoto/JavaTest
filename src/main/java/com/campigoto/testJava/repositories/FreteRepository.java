package com.campigoto.testJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campigoto.testJava.entities.Frete;

public interface FreteRepository extends JpaRepository<Frete, Long> {

}
