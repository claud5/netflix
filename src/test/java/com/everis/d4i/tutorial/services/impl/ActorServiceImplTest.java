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

import com.everis.d4i.tutorial.entities.Actors;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;


public class ActorServiceImplTest {

	private Actors actor;
	private ActorRest actorRest;
	private List<Actors> actorList;
	private List<ActorRest> actorRestList;

	private static final int ACTOR_BIRTH_YEAR = 1986;
	private static final int ACTOR_BIRTH_MONTH = 10;
	private static final int ACTOR_BIRTH_DAY = 23;
	private static final String ACTOR_NAME = "EMILIA";
	private static final String ACTOR_SURNAME = "CLARKE";
	private static final long ACTOR_ID = 1L;
	private static final long ACTOR_WRONG_ID = 10L;
	
	private static final int LIST_LENGTH = 6;
	private static final int INDEX = 0;
	
	@Mock
	private ActorRepository actorRepository;
	
	@InjectMocks
	private ActorServiceImpl actorServiceImpl;

	
	@Before
	public void init() {
		this.actor = createActor();
		this.actorRest = createActorRest();
		this.actorList = createActorsList();
		this.actorRestList = createActorsRestList();
		
		MockitoAnnotations.initMocks(this);

	}
	
	//INIT
	private Actors createActor() {

		// Creem actor que ens retorna bbdd
		Actors actor = new Actors();
		actor.setId(ACTOR_ID);
		actor.setName(ACTOR_NAME);
		actor.setSurname(ACTOR_SURNAME);
		actor.setDate_of_birth(LocalDate.of(ACTOR_BIRTH_YEAR,
				ACTOR_BIRTH_MONTH, ACTOR_BIRTH_DAY));

		return actor;
	}

	private ActorRest createActorRest() {

		// Creem actor que es el que esperem rebre
		ActorRest actor = new ActorRest();
		actor.setName(ACTOR_NAME);
		actor.setSurname(ACTOR_SURNAME);
		actor.setDate_of_birth(LocalDate.of(ACTOR_BIRTH_YEAR, ACTOR_BIRTH_MONTH,
				ACTOR_BIRTH_DAY));

		return actor;
	}

	private List<Actors> createActorsList(){
		List<Actors> list = new ArrayList<Actors>();
		
		for (int i = 0; i < LIST_LENGTH; i++) {
			list.add(actor);
		}
		return list;
	
	}
	
	private List<ActorRest> createActorsRestList(){
		
		List<ActorRest> list = new ArrayList<ActorRest>();
		
		for (int i = 0; i < LIST_LENGTH; i++) {
			list.add(actorRest);
		}
		return list;
	
	}
	
	
	//OK TESTS
	@Test
	public void shouldReturnAnActor() throws Exception {

		// given
		Mockito.when(actorRepository.findById(ACTOR_ID)).thenReturn(Optional.of(actor));

		// when
		ActorRest finalActor = actorServiceImpl.getActorsById(ACTOR_ID);
	
		// then
		assertEquals(actorRest, finalActor);
	}

	@Test
	public void shouldReturnActorList() throws Exception {

		// given
		Mockito.when(actorRepository.findAll()).thenReturn(actorList);

		// when
		List<ActorRest> finalActorsList = actorServiceImpl.getActors();

		// then
		assertEquals(actorRestList.get(INDEX), finalActorsList.get(INDEX));
		assertEquals(LIST_LENGTH, finalActorsList.size());
		
	
	}

	//FAIL TESTS
	@Test (expected = NotFoundException.class)
	public void shouldReturnActorKO() throws Exception{
		
		Mockito.when(actorRepository.findById(ACTOR_WRONG_ID)).thenReturn(Optional.empty());
		
		actorServiceImpl.getActorsById(ACTOR_WRONG_ID);
	
		fail();
	}
	

}
