package com.everis.d4i.tutorial.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.everis.d4i.tutorial.entities.TvShow;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {

	List<TvShow> findByCategoriesId(Long categoryId);
	
	Optional<TvShow> findById(Long id);
	
	HashSet<TvShow> findBySeasonsChaptersActorsId(Long actorId);
	
	List<TvShow> findBySeasonsChaptersActorsIdAndId(Long actorId, Long id);
}
