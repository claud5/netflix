CREATE TABLE IF NOT EXISTS `CATEGORIES`
(
  `ID`          BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `NAME`        VARCHAR(60) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `unique` (`NAME` ASC)
);

CREATE TABLE IF NOT EXISTS `TV_SHOWS`
(
  `ID`          	BIGINT(20)    NOT NULL AUTO_INCREMENT,
  `NAME` 			VARCHAR(256)  NOT NULL,
  `SHORT_DESC` 		VARCHAR(256)  NULL DEFAULT NULL,
  `LONG_DESC` 		VARCHAR(2048) NULL DEFAULT NULL,
  `YEAR` 			YEAR(4) 	  NOT NULL,
  `RECOMMENDED_AGE` TINYINT 	  NOT NULL,
  `ADVERTISING` 	VARCHAR(256)  NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE IF NOT EXISTS `CATEGORY_FOR_SHOW`
(
	`ID`			BIGINT(20) NOT NULL AUTO_INCREMENT,
	`SHOW_ID`		BIGINT(20) NOT NULL,
    `CATEGORY_ID`	BIGINT(20) NOT NULL,
    PRIMARY KEY (`ID`),
		CONSTRAINT `FK_CATEGORY_FOR_SHOW_CATEGORY_ID`
			FOREIGN KEY (CATEGORY_ID) REFERENCES `CATEGORIES` (ID) ON DELETE CASCADE,
		CONSTRAINT `FK_CATEGORY_FOR_SHOW_SHOW_ID`
			FOREIGN KEY (SHOW_ID) REFERENCES `TV_SHOWS` (ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `SEASONS`
(
  `ID`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `NUMBER` 		TINYINT 	 NOT NULL,
  `NAME` 		VARCHAR(256) NOT NULL,
  `TV_SHOW_ID`  BIGINT(20)   NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_SEASONS_TV_SHOW_ID`
    FOREIGN KEY (TV_SHOW_ID) REFERENCES `TV_SHOWS` (ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `CHAPTERS`
(
  `ID`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `NUMBER` 		TINYINT 	 NOT NULL,
  `NAME` 		VARCHAR(256) NOT NULL,
  `DURATION` 	TINYINT 	 NOT NULL,
  `SEASON_ID`  BIGINT(20)   NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_CHAPTERS_SEASON_ID`
    FOREIGN KEY (SEASON_ID) REFERENCES `SEASONS` (ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `AWARDS`
(
	`ID`		BIGINT(20)	NOT NULL AUTO_INCREMENT,
    `NAME`		VARCHAR(50) NOT NULL,
    PRIMARY KEY (`ID`)
);


CREATE TABLE IF NOT EXISTS `AWARD_FOR_SHOW`
(
    `ID_SHOW`	BIGINT(20) NOT NULL,
    `ID_AWARD`	BIGINT(20) NOT NULL,
    `DATE`		DATETIME NOT NULL,
    PRIMARY KEY (`ID_SHOW`, `ID_AWARD`),
    CONSTRAINT `FK_AWARD_FOR_SHOW_SHOW_ID`
		FOREIGN KEY (ID_SHOW) REFERENCES `TV_SHOWS` (ID) ON DELETE CASCADE,
	CONSTRAINT `FK_AWARD_FOR_SHOW_AWARD_ID`
		FOREIGN KEY (ID_AWARD) REFERENCES `AWARDS` (ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `ACTORS`
(
	`ID`		BIGINT(20) NOT NULL AUTO_INCREMENT,
    `NAME`		VARCHAR(50) NOT NULL,
    `SURNAME`	VARCHAR(50) NOT NULL,
    `DATE_OF_BIRTH` DATETIME NOT NULL,
    PRIMARY KEY (`ID`)
);


CREATE TABLE IF NOT EXISTS `ACTORS_IN_CHAPTER`
(
	`ID`		BIGINT(20) NOT NULL AUTO_INCREMENT,
    `ID_ACTOR`	BIGINT(20) NOT NULL,
	`ID_CHAPTER` BIGINT(20) NOT NULL,
    
    PRIMARY KEY (`ID`, `ID_ACTOR`, `ID_CHAPTER`),
	CONSTRAINT `FK_ACTORS_IN_CHAPTER_ACTORS_ID`
		FOREIGN KEY (ID_ACTOR) REFERENCES `ACTORS`(ID) ON DELETE CASCADE,
    CONSTRAINT `FK_ACTORS_IN_CHAPTER_CHAPTER_ID`
		FOREIGN KEY (ID_CHAPTER) REFERENCES `CHAPTERS`(ID) ON DELETE CASCADE     
);

ALTER TABLE CATEGORIES ADD AVAILABLE TINYINT(1) NOT NULL;

