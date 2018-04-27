package com.argento.signaler.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argento.signaler.model.Event;
import com.argento.signaler.repository.EventsRepository;

@RestController
@RequestMapping("/events")
public class EventsController {
	
	EventsRepository eventsRepository;
	
	public EventsController(EventsRepository eventsRepository) {
		this.eventsRepository = eventsRepository;
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Event>> getEvents(){

		List<Event> list = new ArrayList<>();
		
		return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body(list);
		
	}

	@PostMapping("/")
	public ResponseEntity<Event> createEvent(Event event){
		Event newEvent = eventsRepository.save(event);
		
		return ResponseEntity
	            .ok()
	            .body(newEvent);
	}

	
	@PutMapping("/{eventId}")
	public ResponseEntity<Event> updateEvent(@PathVariable Long eventId, @RequestBody Event event){
		Event updatedEvent = eventsRepository.save(event);
		
		return ResponseEntity
	            .ok()
	            .body(updatedEvent);
	}
	
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<String> deletedEvent(@PathVariable Long eventId){
		eventsRepository.deleteById(eventId);
		
		return ResponseEntity
	            .ok()
	            .body("Done");
	}
	
	

}
