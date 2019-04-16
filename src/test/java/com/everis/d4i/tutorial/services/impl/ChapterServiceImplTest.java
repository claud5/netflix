package com.everis.d4i.tutorial.services.impl;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.repositories.ChapterRepository;

public class ChapterServiceImplTest {

	private Chapter returnedChapter;
	
	
	private static final Long CHAPTER_ID = 1L;
	private static final short CHAPTER_NUMBER = 1;
	private static final String CHAPTER_NAME = "Chapter 1";
	private static final short CHAPTER_DURATION = 43;

	private static final Long TV_SHOW_ID = 1L;
	private static final short SEASON_ID = 1;

	
	
	@Before
	public void init() {
		createChapter();
		
		MockitoAnnotations.initMocks(this);
	}
	
	
	private void createChapter() {
		returnedChapter = new Chapter();
		returnedChapter.setId(CHAPTER_ID);
		returnedChapter.setName(CHAPTER_NAME);
		returnedChapter.setNumber(CHAPTER_NUMBER);
		returnedChapter.setDuration(CHAPTER_DURATION);
	}
	
	@Mock
	private ChapterRepository chapterRepository;
	
	@InjectMocks
	private ChapterServiceImpl chapterServiceImpl;
	

}
