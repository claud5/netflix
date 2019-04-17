INSERT INTO CATEGORIES(ID, NAME, AVAILABLE) VALUES 
	(1, 'TERROR',1 ), 
	(2, 'COMEDIA',1 ), 
	(3, 'ACCIÓN', 1);
    
    
INSERT INTO TV_SHOWS(ID, NAME, SHORT_DESC, LONG_DESC, YEAR, RECOMMENDED_AGE) VALUES 
	(1, 'Juego de tronos', 'Descripción corta', 'Descripción larga', '2012', 16), 
	(2, 'American horror Story', NULL, NULL, '2010', 16), 
	(3, 'Big Bang', NULL, NULL, '2008', 18);
    
INSERT INTO SEASONS(ID, NUMBER, NAME, TV_SHOW_ID) VALUES 
	(1, 1, 'One', 1), 
	(2, 2, 'Two', 1), 
	(3, 1, 'One', 2), 
	(4, 2, 'Two', 2), 
	(5, 3, 'Three', 2), 
	(6, 1, 'One', 3);

INSERT INTO CHAPTERS(ID, NUMBER, NAME, DURATION, SEASON_ID) VALUES 
	(1, 1, 'Chapter 1', 43, 1), 
	(2, 2, 'Chapter 2', 45, 1), 
	(3, 3, 'Chapter 3', 44, 1),
	(4, 1, 'Chapter 0', 50, 2);
    
INSERT INTO AWARDS (NAME) VALUES
	('GOYA'),
    ('OSCAR'),
    ('GLOBO ORO');
    
    
INSERT INTO AWARD_FOR_SHOW (ID_SHOW, ID_AWARD, DATE) VALUES
	(1, 2, '2018-01-02'),
    (2, 3, '1996-7-25'),
    (1, 1, '2017-09-17');
    
    
    
INSERT INTO ACTORS  (NAME, SURNAME, DATE_OF_BIRTH) VALUES
    ('EMILIA', 'CLARKE', '1986-10-23'),
    ('KIT', 'HARINGTON', '1986-12-26'),
    ('SARAH', 'PAULSON', '1974-12-17'),
    ('KALEY', 'CUOCO', '1985-11-30'),
    ('JOHNNY', 'GALECKY', '1975-04-30'),
    ('JIM', 'PARSONS', '1973-03-24');

INSERT INTO ACTORS_IN_CHAPTER (ID_ACTOR, ID_CHAPTER) VALUES
	(1,1),
    (1,1),
	(2,1);
    

INSERT INTO CATEGORY_FOR_SHOW (ID, SHOW_ID, CATEGORY_ID) VALUES
	(1,1,3),
    (2,2,1),
    (3,3,2);
    
