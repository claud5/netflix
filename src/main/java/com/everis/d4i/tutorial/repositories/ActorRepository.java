package com.everis.d4i.tutorial.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.d4i.tutorial.entities.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

	Optional<Actor> findById (long id);
	
}
