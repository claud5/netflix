package com.everis.d4i.tutorial.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.d4i.tutorial.controllers.AwardController;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.AwardRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.AwardService;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.RestConstants;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_AWARD)
public class AwardControllerImpl implements AwardController{
	
	@Autowired
	private AwardService awardService;
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_AWARD_IN_TVSHOW, produces = MediaType.APPLICATION_JSON_VALUE)
		public NetflixResponse<List<AwardRest>> getAwardByTvShow(@PathVariable Long tvShowId) throws NetflixException {
		
		return new NetflixResponse<List<AwardRest>>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
					CommonConstants.OK, awardService.getAwardByTvShow(tvShowId));
		
	}
}