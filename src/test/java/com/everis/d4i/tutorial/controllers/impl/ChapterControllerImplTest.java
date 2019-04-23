package com.everis.d4i.tutorial.controllers.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.impl.ChapterServiceImpl;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
import com.everis.d4i.tutorial.utils.constants.TestsConstants;

public class ChapterControllerImplTest {
	
	private Chapter returnedChapter;
	private ChapterRest returnedChapterRest;
	private ActorRest actor;
	private List<Chapter> chapterList;
	private List<ChapterRest> chapterRestList;
	private List<ActorRest> actorRestList;
	
	private static final int LIST_LENGTH = 1;
	
	@Mock
	ChapterRepository chapterRepositori;
	@Mock
	ChapterServiceImpl chapterServiceImpl;
	@InjectMocks
	ChapterControllerImpl chapterControllerImpl;
	
	@Before
	public void init() {
		this.returnedChapter = new Chapter();
		this.returnedChapterRest = new ChapterRest();
		this.actor = new ActorRest();
		
		this.chapterList = new ArrayList<Chapter>();
		this.chapterRestList = new ArrayList<ChapterRest>();
		this.actorRestList = new ArrayList<ActorRest>();
		
		this.chapterList.add(this.returnedChapter);
		this.chapterRestList.add(this.returnedChapterRest);
		this.actorRestList.add(this.actor);
		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void shouldGetAChapter() throws Exception {
		// given
		Mockito.when(chapterRepositori.findBySeasonTvShowIdAndSeasonNumberAndNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER)).thenReturn(Optional.of(returnedChapter));
		Mockito.when(chapterServiceImpl.getChapterByTvShowIdAndSeasonNumberAndChapterNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER)).thenReturn(returnedChapterRest);
	
		//when
		NetflixResponse<ChapterRest> netflixResponse = chapterControllerImpl.getChapterByTvShowIdAndSeasonNumberAndChapterNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER);
		// then
		assertEquals(CommonConstants.SUCCESS, netflixResponse.getStatus());
		assertEquals(String.valueOf(HttpStatus.OK),netflixResponse.getCode());
		assertEquals(returnedChapterRest, netflixResponse.getData());

	}
	
	@Test
	public void shouldGetAChapterList() throws Exception {
		// given
		Mockito.when(chapterRepositori.findBySeasonTvShowIdAndSeasonNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID)).thenReturn(chapterList);
		Mockito.when(chapterServiceImpl.getChaptersByTvShowIdAndSeasonNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID)).thenReturn(chapterRestList);
	
		//when
		NetflixResponse<List<ChapterRest>> netflixResponse = chapterControllerImpl.getChaptersByTvShowIdAndSeasonNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID);
		// then
		assertEquals(CommonConstants.SUCCESS, netflixResponse.getStatus());
		assertEquals(String.valueOf(HttpStatus.OK),netflixResponse.getCode());
		assertEquals(LIST_LENGTH, netflixResponse.getData().size());
		assertEquals(returnedChapterRest, netflixResponse.getData().get(TestsConstants.INDEX));
	}
	
	@Test
	public void shouldGetAnActorList() throws Exception {
		// given
		Mockito.when(chapterRepositori.findBySeasonTvShowIdAndSeasonNumberAndNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER)).thenReturn(Optional.of(returnedChapter));
		Mockito.when(chapterServiceImpl.getActorsFromChapterByTvShowIdAndSeasonNumberAndChapterNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER)).thenReturn(actorRestList);
	
		//when
		NetflixResponse<List<ActorRest>> netflixResponse = chapterControllerImpl.getActorsFromChapterByTvShowIdAndSeasonNumberAndChapterNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER);
		// then
		assertEquals(CommonConstants.SUCCESS, netflixResponse.getStatus());
		assertEquals(String.valueOf(HttpStatus.OK),netflixResponse.getCode());
		assertEquals(LIST_LENGTH, netflixResponse.getData().size());
		assertEquals(actor.getName(), netflixResponse.getData().get(TestsConstants.INDEX).getName());
		assertEquals(actor.getSurname(), netflixResponse.getData().get(TestsConstants.INDEX).getSurname());
		assertEquals(actor.getDate_of_birth(), netflixResponse.getData().get(TestsConstants.INDEX).getDate_of_birth());

	}
	
	@Test
	public void shouldUpdateChapterName() throws Exception {
		// given
		Mockito.when(chapterRepositori.findBySeasonTvShowIdAndSeasonNumberAndNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER)).thenReturn(Optional.of(returnedChapter));
		Mockito.when(chapterRepositori.save(returnedChapter)).thenReturn(returnedChapter);
		Mockito.when(chapterServiceImpl.updateChpaterName(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER, TestsConstants.CHAPTER_NEW_NAME)).thenReturn(returnedChapterRest);
	
		//when
		NetflixResponse<ChapterRest> netflixResponse = chapterControllerImpl.updateChapterName(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER, TestsConstants.CHAPTER_NEW_NAME);
		// then
		assertEquals(CommonConstants.SUCCESS, netflixResponse.getStatus());
		assertEquals(String.valueOf(HttpStatus.OK),netflixResponse.getCode());
		assertEquals(returnedChapterRest.getName(), netflixResponse.getData().getName());
	}
	
	
	//FAIL TEST
	@Test(expected=NotFoundException.class)
	public void shouldGetAChapterKO() throws Exception {
		// given
		Mockito.when(chapterRepositori.findBySeasonTvShowIdAndSeasonNumberAndNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.WRONG_CHAPTER_NUMBER)).thenReturn(Optional.empty());
		Mockito.when(chapterServiceImpl.getChapterByTvShowIdAndSeasonNumberAndChapterNumber(TestsConstants.TV_SHOW_ID,
				TestsConstants.SEASON_ID, TestsConstants.WRONG_CHAPTER_NUMBER))
					.thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
	
		//when
		chapterControllerImpl.getChapterByTvShowIdAndSeasonNumberAndChapterNumber(
				TestsConstants.TV_SHOW_ID, TestsConstants.SEASON_ID, TestsConstants.WRONG_CHAPTER_NUMBER);
		// then
		fail();

	}

	
	
	
}
