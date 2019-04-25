package com.everis.d4i.tutorial.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.utils.constants.TestsConstants;

public class ChapterServiceImplTest {

	private Chapter returnedChapter;
	private ChapterRest expectedChapter;
	private List<Chapter> chapterList;
	private List<ChapterRest> chapterRestList;
	private List<ActorRest> expectedActorsList;
	
	private static final int CHAPTER_LIST_LENGTH = 4;
	private static final int ACTOR_LIST_LENGTH = 3;


	@Mock
	private ChapterRepository chapterRepository;
	@InjectMocks
	private ChapterServiceImpl chapterServiceImpl;
	
	
	@Before
	public void init() {
		createChapter();
		createChapterRest();
		createChaptersList();
		this.expectedActorsList = createActorsRestList();
		MockitoAnnotations.initMocks(this);
	}
	
	
	private void createChapter() {
		returnedChapter = new Chapter();
		returnedChapter.setId(TestsConstants.CHAPTER_ID);
		returnedChapter.setName(TestsConstants.CHAPTER_NAME);
		returnedChapter.setNumber(TestsConstants.CHAPTER_NUMBER);
		returnedChapter.setDuration(TestsConstants.CHAPTER_DURATION);
		
		List<Actor> actors = createActorsList();
		returnedChapter.setActors(actors);
		
	}
	
	private void createChapterRest() {
		expectedChapter = new ChapterRest();
		expectedChapter.setName(TestsConstants.CHAPTER_NAME);
		expectedChapter.setNumber(TestsConstants.CHAPTER_NUMBER);
		expectedChapter.setDuration(TestsConstants.CHAPTER_DURATION);
		
	}
	
	private void createChaptersList() {
		this.chapterList = new ArrayList<Chapter>();
		this.chapterRestList = new ArrayList<ChapterRest>();
		
		for (int i = 0; i < CHAPTER_LIST_LENGTH; i++) {
			chapterList.add(returnedChapter);
		}
		
		for (int i = 0; i < CHAPTER_LIST_LENGTH; i++) {
			chapterRestList.add(expectedChapter);
		}
	}

	private List<Actor> createActorsList() {
		List<Actor> list = new ArrayList<Actor>();
		Actor actor = new Actor();
		actor.setId(TestsConstants.ACTOR_ID);
		actor.setName(TestsConstants.ACTOR_NAME);
		actor.setSurname(TestsConstants.ACTOR_SURNAME);
		actor.setDate_of_birth(LocalDate.of(TestsConstants.ACTOR_BIRTH_YEAR,
				TestsConstants.ACTOR_BIRTH_MONTH, TestsConstants.ACTOR_BIRTH_DAY));
		
		for(int  i = 0; i < ACTOR_LIST_LENGTH; i++) {
			list.add(actor);
		}
		
		return list;
	}

	private List<ActorRest> createActorsRestList() {
		List<ActorRest> list = new ArrayList<ActorRest>();
		ActorRest actor = new ActorRest();
		actor.setName(TestsConstants.ACTOR_NAME);
		actor.setSurname(TestsConstants.ACTOR_SURNAME);
		actor.setDate_of_birth(LocalDate.of(TestsConstants.ACTOR_BIRTH_YEAR,
				TestsConstants.ACTOR_BIRTH_MONTH, TestsConstants.ACTOR_BIRTH_DAY));
		
		for(int  i = 0; i < ACTOR_LIST_LENGTH; i++) {
			list.add(actor);
		}
		
		return list;
		

	}
	

	
	//OK TESTS
	@Test
	public void shouldReturnAChapter() throws Exception {
		//given
		Mockito.when(chapterRepository.findBySeasonTvShowIdAndSeasonNumberAndNumber(TestsConstants.TV_SHOW_ID, 
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER)).thenReturn(Optional.of(returnedChapter));
		
		//when
		ChapterRest finalChapter = chapterServiceImpl.getChapterByTvShowIdAndSeasonNumberAndChapterNumber(TestsConstants.TV_SHOW_ID, 
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER);
		
		//then
		assertEquals(expectedChapter.getName(), finalChapter.getName());
		assertEquals(expectedChapter.getNumber(), finalChapter.getNumber());
	}
	
	@Test
	public void shouldReturnAChapterList() throws Exception{
		//given
		Mockito.when(chapterRepository.findBySeasonTvShowIdAndSeasonNumber(TestsConstants.TV_SHOW_ID, 
				TestsConstants.SEASON_ID)).thenReturn(chapterList);
		
		//when
		List<ChapterRest> finalList = chapterServiceImpl.getChaptersByTvShowIdAndSeasonNumber(TestsConstants.TV_SHOW_ID, 
				TestsConstants.SEASON_ID);
		
		//then
		assertEquals(CHAPTER_LIST_LENGTH, finalList.size());
		assertEquals(expectedChapter.getName(), finalList.get(TestsConstants.INDEX).getName());
		assertEquals(expectedChapter.getNumber(), finalList.get(TestsConstants.INDEX).getNumber());

	}
	
	@Test
	public void shouldReturnAnActorsList() throws Exception {
		//given
		Mockito.when(chapterRepository.findBySeasonTvShowIdAndSeasonNumberAndNumber(TestsConstants.TV_SHOW_ID, 
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER)).thenReturn(Optional.of(returnedChapter));
		
		//when
		 List<ActorRest> finalActorsList = chapterServiceImpl.getActorsFromChapterByTvShowIdAndSeasonNumberAndChapterNumber(TestsConstants.TV_SHOW_ID, 
					TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER);
		 
		//then
		assertEquals(expectedActorsList.size(), finalActorsList.size());
		assertEquals(expectedActorsList.get(TestsConstants.INDEX), finalActorsList.get(TestsConstants.INDEX));
	}
	
	public void shouldUpdateChapterName() throws Exception{
		Mockito.when(chapterRepository.findBySeasonTvShowIdAndSeasonNumberAndNumber(TestsConstants.TV_SHOW_ID, 
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER)).thenReturn(Optional.of(returnedChapter));
		
		ChapterRest finalChapter = chapterServiceImpl.updateChpaterName(TestsConstants.TV_SHOW_ID, 
				TestsConstants.SEASON_ID, TestsConstants.CHAPTER_NUMBER, TestsConstants.CHAPTER_NEW_NAME);
		
		assertEquals(TestsConstants.CHAPTER_NEW_NAME, finalChapter.getName());
		
	}
	
	
	
	//FAIL TESTS
	@Test (expected = NotFoundException.class)
	public void shouldReturnAChapterKO() throws Exception{
		//given
		Mockito.when(chapterRepository.findBySeasonTvShowIdAndSeasonNumberAndNumber(TestsConstants.TV_SHOW_ID, TestsConstants.SEASON_ID, TestsConstants.WRONG_CHAPTER_NUMBER)).thenReturn(Optional.empty());
		
		//when
		chapterServiceImpl.getChapterByTvShowIdAndSeasonNumberAndChapterNumber(TestsConstants.TV_SHOW_ID,  TestsConstants.SEASON_ID, TestsConstants.WRONG_CHAPTER_NUMBER);
		
		fail();
	}
	
	@Test (expected = NotFoundException.class)
	public void shouldReturnAChapterSeasonIdKO() throws Exception{
		//given
		Mockito.when(chapterRepository.findBySeasonTvShowIdAndSeasonNumberAndNumber(TestsConstants.TV_SHOW_ID, TestsConstants.WRONG_SEASON_ID, TestsConstants.CHAPTER_NUMBER)).thenReturn(Optional.empty());
		
		//when
		chapterServiceImpl.getChapterByTvShowIdAndSeasonNumberAndChapterNumber(TestsConstants.TV_SHOW_ID, TestsConstants.WRONG_SEASON_ID, TestsConstants.CHAPTER_NUMBER);
		
		fail();
	}
	
	
	
	

}
