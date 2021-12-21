package com.api.personas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.personas.entity.Personas;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, String> {

}
