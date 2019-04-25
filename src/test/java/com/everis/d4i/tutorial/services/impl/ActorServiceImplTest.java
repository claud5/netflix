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
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import com.everis.d4i.tutorial.utils.constants.TestsConstants;


public class ActorServiceImplTest {

	private Actor actor;
	private ActorRest actorRest;
	private List<Actor> actorList;
	private List<ActorRest> actorRestList;

	public static final int ACTOR_LIST_LENGTH = 6;

	
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
	private Actor createActor() {

		// Creem actor que ens retorna bbdd
		Actor actor = new Actor();
		actor.setId(TestsConstants.ACTOR_ID);
		actor.setName(TestsConstants.ACTOR_NAME);
		actor.setSurname(TestsConstants.ACTOR_SURNAME);
		actor.setDate_of_birth(LocalDate.of(TestsConstants.ACTOR_BIRTH_YEAR,
				TestsConstants.ACTOR_BIRTH_MONTH, TestsConstants.ACTOR_BIRTH_DAY));

		return actor;
	}

	private ActorRest createActorRest() {

		// Creem actor que es el que esperem rebre
		ActorRest actor = new ActorRest();
		actor.setName(TestsConstants.ACTOR_NAME);
		actor.setSurname(TestsConstants.ACTOR_SURNAME);
		actor.setDate_of_birth(LocalDate.of(TestsConstants.ACTOR_BIRTH_YEAR, TestsConstants.ACTOR_BIRTH_MONTH,
				TestsConstants.ACTOR_BIRTH_DAY));

		return actor;
	}

	private List<Actor> createActorsList(){
		List<Actor> list = new ArrayList<Actor>();
		
		for (int i = 0; i < ACTOR_LIST_LENGTH; i++) {
			list.add(actor);
		}
		return list;
	
	}
	
	private List<ActorRest> createActorsRestList(){
		
		List<ActorRest> list = new ArrayList<ActorRest>();
		
		for (int i = 0; i < ACTOR_LIST_LENGTH; i++) {
			list.add(actorRest);
		}
		return list;
	
	}
	
	
	//OK TESTS
	@Test
	public void shouldReturnAnActor() throws Exception {

		// given
		Mockito.when(actorRepository.findById(TestsConstants.ACTOR_ID)).thenReturn(Optional.of(actor));

		// when
		ActorRest finalActor = actorServiceImpl.getActorsById(TestsConstants.ACTOR_ID);
	
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
		assertEquals(actorRestList.get(TestsConstants.INDEX), finalActorsList.get(TestsConstants.INDEX));
		assertEquals(ACTOR_LIST_LENGTH, finalActorsList.size());
		
	
	}

	//FAIL TESTS
	@Test (expected = NotFoundException.class)
	public void shouldReturnActorKO() throws Exception{
		
		Mockito.when(actorRepository.findById(TestsConstants.ACTOR_WRONG_ID)).thenReturn(Optional.empty());
		
		actorServiceImpl.getActorsById(TestsConstants.ACTOR_WRONG_ID);
	
		fail();
	}
	

}
