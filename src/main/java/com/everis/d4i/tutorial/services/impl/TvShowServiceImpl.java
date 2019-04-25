
package com.everis.d4i.tutorial.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Category;
import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.entities.TvShowChapters;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import com.everis.d4i.tutorial.repositories.CategoryRepository;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import com.everis.d4i.tutorial.services.TvShowService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class TvShowServiceImpl implements TvShowService {

	@Autowired
	private TvShowRepository tvShowRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ChapterRepository chapterRepository;
	@Autowired
	private ActorRepository actorRepository;

	private ModelMapper modelMapper = new ModelMapper();

	private static final int FIRST_POSITION = 0;
	private static final int SECOND_POSITION = 1;
	private static final int ONE_POSITION = 1;

	@Override
	public List<TvShowRest> getTvShowsByCategory(final Long categoryId) throws NetflixException {

		return tvShowRepository.findByCategoriesId(categoryId).stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowRest.class)).collect(Collectors.toList());

	}

	@Override
	public TvShowRest getTvShowById(final Long id) throws NetflixException {

		TvShow show = getById(id);

		return modelMapper.map(show, TvShowRest.class);
	}

	@Override
	public TvShowRest updateName(final String name, final Long id) throws NetflixException {
		TvShow show = getById(id);

		show.setName(name);

		return modelMapper.map(saveTvShow(show), TvShowRest.class);
	}

	@Override
	public TvShowRest addCategory(final Long tvShowId, final Long categoryId) throws NetflixException {
		TvShow show = getById(tvShowId);
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CATEGORY));

		show.getCategories().add(category);
		category.getTvShows().add(show);

		categoryRepository.saveAndFlush(category);

		return modelMapper.map(saveTvShow(show), TvShowRest.class);
	}

	@Override
	public void deleteTvShowById(final Long id) throws NetflixException{
		tvShowRepository.deleteById(id);
	}

	@Override
	public List<TvShowChapters> getTvShowChapterFromActor(final Long actorId) throws NetflixException {
		HashSet<TvShow> tvShowsByActor = tvShowRepository.findBySeasonsChaptersActorsId(actorId);

		Map<Long, List<TvShow>> cleanTvShowByActor = tvShowsByActor.stream()
				.collect(Collectors.groupingBy(TvShow::getId));

		return organizesTvShowByActor(cleanTvShowByActor, actorId);
	}

	private List<TvShowChapters> organizesTvShowByActor(final Map<Long, List<TvShow>> cleanTvShowByActor, final Long actorId) {
		List<Chapter> chapters = chapterRepository.findByActorsId(actorId);
		List<TvShowChapters> tvShowList = new ArrayList<TvShowChapters>();

		cleanTvShowByActor.entrySet().stream().forEach(show -> show.getValue().stream().forEach(finalShow -> {
			TvShowChapters tv = new TvShowChapters();
			tv.setId(finalShow.getId());
			tv.setName(finalShow.getName());
			tv.setShortDescription(finalShow.getShortDescription());
			tv.setYear(finalShow.getYear());
			List<Chapter> chaptList = new ArrayList<Chapter>();

			chapters.stream().forEach(chapter -> {
				if (chapter.getSeason().getTvShow().getId().equals(tv.getId())) {
					chaptList.add(chapter);
				}
			});
			tv.setChapters(chaptList.stream().map(chapter -> modelMapper.map(chapter, ChapterRest.class))
					.collect(Collectors.toList()));
			tvShowList.add(tv);

		}));

		return tvShowList;
	}

	private TvShow getById(final Long id) throws NotFoundException {
		return tvShowRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SHOW));

	}

	private TvShow saveTvShow(final TvShow show) {
		return tvShowRepository.saveAndFlush(show);
	}

}
