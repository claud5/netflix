package com.everis.d4i.tutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.d4i.tutorial.entities.Award;

public interface AwardRepository extends JpaRepository<Award, Long>{

	List<Award> findByAwardsForShowTvShowId(Long id);
	
}
