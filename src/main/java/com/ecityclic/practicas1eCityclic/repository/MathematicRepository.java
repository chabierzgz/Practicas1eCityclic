package com.ecityclic.practicas1eCityclic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecityclic.practicas1eCityclic.entity.MathematicsOperations;

@Repository
public interface MathematicRepository extends JpaRepository<MathematicsOperations, Integer>{

}
