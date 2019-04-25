package com.everis.d4i.tutorial.utils.constants;

public class TestsConstants {
	//ACTOR
	public static final int ACTOR_BIRTH_YEAR = 1986;
	public static final int ACTOR_BIRTH_MONTH = 10;
	public static final int ACTOR_BIRTH_DAY = 23;
	public static final String ACTOR_NAME = "EMILIA";
	public static final String ACTOR_SURNAME = "CLARKE";
	public static final long ACTOR_ID = 1L;
	public static final long ACTOR_WRONG_ID = 10L;
	
	
	//CHAPTER
	public static final Long CHAPTER_ID = 1L;
	public static final short CHAPTER_NUMBER = 1;
	public static final String CHAPTER_NAME = "Chapter 1";
	public static final short CHAPTER_DURATION = 43;
	public static final String CHAPTER_NEW_NAME = "New Name";
	public static final short WRONG_CHAPTER_NUMBER = 10;

	
	//TVSHOW
	public static final Long TV_SHOW_ID = 1L;

	//SEASON
	public static final short SEASON_ID = 1;
	public static final short WRONG_SEASON_ID = 10;
	
	public static final int INDEX = 0;

	
	private TestsConstants() {
		throw new IllegalStateException("Utility Class");
	}
}
