package com.everis.d4i.tutorial.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.AwardForShow;
import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.AwardForShowRest;
import com.everis.d4i.tutorial.json.AwardRest;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import com.everis.d4i.tutorial.services.TvShowService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class TvShowServiceImpl implements TvShowService {

	@Autowired
	private TvShowRepository tvShowRepository;

	private ModelMapper modelMapper = new ModelMapper();

	/*@Override
	public List<TvShowRest> getTvShowsByCategory(Long categoryId) throws NetflixException {

		return tvShowRepository.findByCategoryId(categoryId).stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowRest.class)).collect(Collectors.toList());

	}*/

	@Override
	public TvShowRest getTvShowById(Long id) throws NetflixException {
		
		TvShow show =  tvShowRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SHOW));
		
		return modelMapper.map(show, TvShowRest.class);
	}
	
	@Override
	public List<TvShowRest> getShowAwards() throws NetflixException {

		
		List<TvShow> awardForShowList = tvShowRepository.findAll();
		
		return awardForShowList.stream().map(award -> modelMapper.map(award, TvShowRest.class))
			.collect(Collectors.toList());	
		}

	@Override 
	public TvShowRest updateName(String name, Long id) throws NetflixException {
		TvShow show = tvShowRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SHOW));

		show.setName(name);
		
		return modelMapper.map(tvShowRepository.saveAndFlush(show), TvShowRest.class);
	}
}
