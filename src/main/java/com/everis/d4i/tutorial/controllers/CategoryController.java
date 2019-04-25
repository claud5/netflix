package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.CategoryRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface CategoryController {

	NetflixResponse<List<CategoryRest>> getCategories() throws NetflixException;

	NetflixResponse<CategoryRest> deleteCategoryAvailability(final Long id) throws NetflixException;

	NetflixResponse<List<CategoryRest>> getAvailableCategories() throws NetflixException;
}
