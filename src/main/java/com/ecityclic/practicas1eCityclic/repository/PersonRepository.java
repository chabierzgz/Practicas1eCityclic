package com.ecityclic.practicas1eCityclic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecityclic.practicas1eCityclic.beans.Persona;

public interface PersonRepository extends JpaRepository<Persona, Long> {
}