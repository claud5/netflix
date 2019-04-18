package com.everis.d4i.tutorial.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Category;
import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.repositories.CategoryRepository;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import com.everis.d4i.tutorial.services.TvShowService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class TvShowServiceImpl implements TvShowService {

	@Autowired
	private TvShowRepository tvShowRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<TvShowRest> getTvShowsByCategory(Long categoryId) throws NetflixException {

		return tvShowRepository.findByCategoriesId(categoryId).stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowRest.class)).collect(Collectors.toList());

	}

	@Override
	public TvShowRest getTvShowById(Long id) throws NetflixException {

		TvShow show = getById(id);
		return modelMapper.map(show, TvShowRest.class);
	}

	@Override
	public TvShowRest updateName(String name, Long id) throws NetflixException {

		TvShow show = getById(id);
		show.setName(name);

		return modelMapper.map(saveTvShow(show), TvShowRest.class);
	}

	@Override
	public TvShowRest addCategory(Long tvShowId, Long categoryId) throws NetflixException {
		TvShow show = getById(tvShowId);
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY));

		List<Category> categoriesList = show.getCategories();
		categoriesList.add(category);
		show.setCategories(categoriesList);

		List<TvShow> showList = category.getTvShows();
		showList.add(show);
		category.setTvShows(showList);
		categoryRepository.saveAndFlush(category);

		return modelMapper.map(saveTvShow(show), TvShowRest.class);
	}

	@Override
	public Boolean deleteTvShowById(Long id) {
		try {
			tvShowRepository.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	private TvShow getById(Long id) throws NotFoundException {
		return tvShowRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SHOW));

	}

	private TvShow saveTvShow(TvShow show) {
		return tvShowRepository.saveAndFlush(show);
	}

}
