package com.everis.d4i.tutorial.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Award;
import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.entities.TvShowAwards;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.AwardRest;
import com.everis.d4i.tutorial.json.TvShowAwardsRest;
import com.everis.d4i.tutorial.repositories.AwardRepository;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import com.everis.d4i.tutorial.services.AwardService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class AwardServiceImpl implements AwardService {

	@Autowired
	private AwardRepository awardRepository;
	@Autowired
	private TvShowRepository tvShowRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<AwardRest> getAwardByTvShow(final Long id) throws NetflixException {

		return awardRepository.findByAwardsForShowTvShowId(id).stream()
				.map(award -> modelMapper.map(award, AwardRest.class)).collect(Collectors.toList());
	}

	@Override
	public AwardRest setAwardToTvShow(Long awardId, Long tvShowId) throws NetflixException {

		TvShow tvShow = tvShowRepository.findById(tvShowId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SHOW));

		Award award = getAwardById(awardId);

		return saveTvShowAwards(award, tvShow);
	}

	@Override
	public void deleteAward(Long id) throws NetflixException {
		awardRepository.deleteById(id);
	}

	@Override
	public AwardRest updateAwardName(Long awardId, String newName) throws NetflixException {
		Award award = getAwardById(awardId);
		award.setName(newName);
		return saveAward(award);
	}

	private Award getAwardById(final Long awardId) throws NetflixException {
		return awardRepository.findById(awardId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_AWARD));
	}

	private AwardRest saveTvShowAwards(final Award award, final TvShow tvShow) throws NetflixException {
		TvShowAwards tvShowAwards = new TvShowAwards();

		tvShow.getAwardForShow().add(tvShowAwards);
		tvShowAwards.setAward(award);
		tvShowAwards.setTvShow(tvShow);
		tvShowAwards.setDate(LocalDate.now());

		return saveAward(award);
	}
	

	private AwardRest saveAward(Award award) throws NetflixException {
		return modelMapper.map(awardRepository.save(award), AwardRest.class);

	}

}
