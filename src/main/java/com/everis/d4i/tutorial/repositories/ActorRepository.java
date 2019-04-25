package com.everis.d4i.tutorial.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.d4i.tutorial.entities.Actors;
import com.everis.d4i.tutorial.json.ActorRest;

@Repository
public interface ActorRepository extends JpaRepository<Actors, Long> {

	Optional<Actors> findById (long id);
	
}
