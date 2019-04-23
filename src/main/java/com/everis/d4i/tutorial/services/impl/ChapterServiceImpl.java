package com.everis.d4i.tutorial.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.services.ChapterService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterRepository chapterRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ChapterRest> getChaptersByTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber)
			throws NetflixException {
		return chapterRepository.findBySeasonTvShowIdAndSeasonNumber(tvShowId, seasonNumber).stream()
				.map(chapter -> modelMapper.map(chapter, ChapterRest.class)).collect(Collectors.toList());
	}

	@Override
	public ChapterRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(final Long tvShowId,
			final short seasonNumber, final short chapterNumber) throws NetflixException {

		Chapter chapter = getChapterById(tvShowId, seasonNumber, chapterNumber);
		return modelMapper.map(chapter, ChapterRest.class);
	}

	@Override
	public List<ActorRest> getActorsFromChapterByTvShowIdAndSeasonNumberAndChapterNumber(final Long tvShowId,
			final short seasonNumber, final short chapterNumber) throws NetflixException {
		Chapter chapter = getChapterById(tvShowId, seasonNumber, chapterNumber);

		return chapter.getActors().stream().map(actors -> modelMapper.map(actors, ActorRest.class))
				.collect(Collectors.toList());
	}

	@Override
	public ChapterRest updateChpaterName(final Long tvShowId, final short seasonNumber, final short chapterNumber,
			final String name) throws NetflixException {
		Chapter chapter = getChapterById(tvShowId, seasonNumber, chapterNumber);
		chapter.setName(name);
		return saveChapter(chapter);
	}

	private Chapter getChapterById(Long tvShowId, short seasonNumber, short chapterNumber) throws NetflixException {
		return chapterRepository.findBySeasonTvShowIdAndSeasonNumberAndNumber(tvShowId, seasonNumber, chapterNumber)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
	}

	private ChapterRest saveChapter(Chapter chapter) {
		return modelMapper.map(chapterRepository.save(chapter), ChapterRest.class);
	}
}
