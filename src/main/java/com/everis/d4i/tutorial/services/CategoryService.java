package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.CategoryRest;

public interface CategoryService {

	List<CategoryRest> getCategories() throws NetflixException;

	CategoryRest disableCategory(Long id) throws NetflixException;

	List<CategoryRest> getAvailableCategories() throws NetflixException;
}
