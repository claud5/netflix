package com.everis.d4i.tutorial.utils.constants;

public class RestConstants {

	public static final String APPLICATION_NAME = "/netflix";
	public static final String API_VERSION_1 = "/v1";
	public static final String SUCCESS = "Success";
 

	// Categories
	public static final String RESOURCE_CATEGORY = "/categories";
	public static final String RESOUCE_CATEGORY_DISABLE ="/{categoryId}/disable";
	public static final String RESOURCE_CATEGORY_AVAILABLE = "/available";
	
	// TV-SHOW
	public static final String RESOURCE_TV_SHOW = "/tv-shows";
	public static final String RESOURCE_TV_SHOW_AWARDS = "/{tvShowId}/awards";
	public static final String RESOURCE_TV_SHOW_UPDATE_NAME = "/{tvShowId}/newName";
	public static final String RESOURCE_TV_SHOW_ADD_CATEGORY = "/{tvShowId}/category";
	public static final String RESOURCE_TV_SHOW_DELETE = "/{tvShowId}/delete";
	public static final String RESOURCE_TV_SHOW_CHAPTER_FROM_ACTOR = "/chapters/actor/{actorId}";
	//SEASONS
	public static final String RESOURCE_SEASON = "/tv-shows/{tvShowId}/seasons";
	
	//CHAPTERS
	public static final String RESOURCE_CHAPTER = "/tv-shows/{tvShowId}/seasons/{seasonNumber}/chapters";
	public static final String RESOURCE_ACTORS_IN_CHAPTER = "/{chapterNumber}/actors";
	public static final String RESOURCE_CHAPTER_UPDATE_NAME = "/{chapterNumber}/newName";

	// Actors
	public static final String RESOURCE_ACTORS = "/actors";
	
	//AWARDS
	public static final String RESOURCE_AWARD ="/awards";
	public static final String RESOURCE_AWARD_IN_TVSHOW = "/tv-show/{tvShowId}";
	public static final String RESOURCE_SET_AWARD_TVSHOW = "/tv-show/";
	// Specific values
	public static final String PARAMETER_ID = "/{id}";
	public static final String PARAMETER_NUMBER = "/{number}";

	private RestConstants() {
		throw new IllegalStateException("Utility Class");
	}

}
