package com.everis.d4i.tutorial.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Category;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.CategoryRest;
import com.everis.d4i.tutorial.repositories.CategoryRepository;
import com.everis.d4i.tutorial.services.CategoryService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	private ModelMapper modelMapper = new ModelMapper();

	private static final boolean AVAILABLE = true;

	@Override
	public List<CategoryRest> getCategories() throws NetflixException {

		return categoryRepository.findAll().stream().map(category -> modelMapper.map(category, CategoryRest.class))
				.collect(Collectors.toList());

	}

	@Override
	public CategoryRest disableCategory(final Long id) throws NetflixException {
		Category category = findById(id);
		category.setAvailable(false);

		return modelMapper.map(categoryRepository.saveAndFlush(category), CategoryRest.class);

	}

	@Override
	public List<CategoryRest> getAvailableCategories() throws NetflixException {

		return categoryRepository.findByAvailable(AVAILABLE).stream()
				.map(category -> modelMapper.map(category, CategoryRest.class)).collect(Collectors.toList());
	}

	private Category findById(final Long id) throws NetflixException {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY));
	}

}
