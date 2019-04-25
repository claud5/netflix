package com.everis.d4i.tutorial.utils.constants;

public class RestConstants {

	public static final String APPLICATION_NAME = "/netflix";
	public static final String API_VERSION_1 = "/v1";
	public static final String SUCCESS = "Success";
 
	// Actors
	public static final String RESOURCE_ACTORS = "/actors";

	// Categories
	public static final String RESOURCE_CATEGORY = "/categories";

	// TV-SHOW
	public static final String RESOURCE_TV_SHOW = "/tv-shows";
	public static final String RESOURCE_TV_SHOW_AWARDS = "{tvShowId}/awards";
	public static final String RESOURCE_TV_SHOW_UPDATE_NAME = "{tvShowId}/name/{newName}";

	//SEASONS
	public static final String RESOURCE_SEASON = "/tv-shows/{tvShowId}/seasons";
	
	//CHAPTERS
	public static final String RESOURCE_CHAPTER = "/tv-shows/{tvShowId}/seasons/{seasonNumber}/chapters";
	public static final String RESOURCE_ACTORS_IN_CHAPTER = "/{chapterNumber}/actors";
	public static final String RESOURCE_CHAPTER_UPDATE_NAME = "/tv-shows/{tvShowId}/seasons/{seasonNumber}/chapters/{chapterId}/name/{newName}";


	// Specific values
	public static final String PARAMETER_ID = "/{id}";
	public static final String PARAMETER_NUMBER = "/{number}";

	private RestConstants() {
		throw new IllegalStateException("Utility Class");
	}

}
