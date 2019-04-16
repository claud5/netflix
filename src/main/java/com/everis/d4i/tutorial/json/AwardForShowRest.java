package com.everis.d4i.tutorial.json;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AwardForShowRest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9112226527906371895L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "DATE", unique = true)
	private Date date;
	
	
}
