package com.argento.signaler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.argento.signaler.model.Event;

@Repository
public interface EventsRepository extends CrudRepository<Event, Long>{

	
	
	
}
