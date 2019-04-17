package com.everis.d4i.tutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.d4i.tutorial.entities.Category;
import com.everis.d4i.tutorial.json.CategoryRest;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByAvailable (boolean available);
}
