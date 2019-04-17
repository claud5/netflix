package com.everis.d4i.tutorial.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.d4i.tutorial.controllers.TvShowController;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.TvShowService;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.RestConstants;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_TV_SHOW)
public class TvShowControllerImpl implements TvShowController {

	@Autowired
	private TvShowService tvShowService;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<TvShowRest>> getTvShowsByCategory(@RequestParam Long categoryId)
			throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.getTvShowsByCategory(categoryId));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.PARAMETER_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<TvShowRest> getTvShowById(@PathVariable Long id) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.getTvShowById(id));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PatchMapping(value = RestConstants.RESOURCE_TV_SHOW_UPDATE_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody NetflixResponse<TvShowRest> updateName(@PathVariable Long tvShowId, @RequestParam String newName) throws NetflixException {
		
		return new NetflixResponse<TvShowRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.updateName(newName, tvShowId));

	}
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	@PatchMapping(value = RestConstants.RESOURCE_TV_SHOW_ADD_CATEGORY, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody NetflixResponse<TvShowRest> addCategory(@PathVariable Long tvShowId, @RequestParam Long categoryId) throws NetflixException {
		
		return new NetflixResponse<TvShowRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.addCategory(tvShowId, categoryId));	
		}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = RestConstants.RESOURCE_TV_SHOW_DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<Boolean> deleteTvShowById(Long tvShowId) {
		
		return new NetflixResponse<Boolean>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				tvShowService.deleteTvShowById(tvShowId));
	}


	
	

}
