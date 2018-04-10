package com.wedding.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wedding.model.Venue;
import com.wedding.repository.VenueRepository;

public class VenueController {

	VenueRepository venueRepository;

	public VenueController(VenueRepository venueRepository) {
		this.venueRepository = venueRepository;
	}

	// to save userdetails in the database via registration
	@RequestMapping(value = "/venue", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> add(@RequestBody Venue venue) {
		Map<String, String> response = new HashMap<String, String>();

		venueRepository.save(venue);
		response.put("ok", "Venue added Succesfuly");
		return ResponseEntity.accepted().body(response);
	}

}
