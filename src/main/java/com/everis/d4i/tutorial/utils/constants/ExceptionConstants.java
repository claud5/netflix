package com.everis.d4i.tutorial.utils.constants;

public class ExceptionConstants {

	public static final String ERROR = "ERROR";

	public static final String MESSAGE_INEXISTENT_SEASON = "SEASON INEXISTENT - Season does not exist";
	public static final String MESSAGE_INEXISTENT_CHAPTER = "CHAPTER INEXISTENT - Chapter does not exist";
	public static final String MESSAGE_INEXISTENT_ACTOR = "ACTOR INEXISTENT - Actor does not exist";
	public static final String MESSAGE_INEXISTENT_SHOW = "TV-SHOW INEXISTENT - Show does not exist";
	public static final String MESSAGE_INEXISTENT_CATEGORY = "CATEGORY INEXISTENT - Category does not exist";

	private ExceptionConstants() {
		throw new IllegalStateException("Utility Class");
	}

}
