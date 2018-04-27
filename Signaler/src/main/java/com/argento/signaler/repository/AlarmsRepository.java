package com.argento.signaler.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.argento.signaler.model.Alarm;

@Repository
public interface AlarmsRepository extends CrudRepository<Alarm, Long>{

	
	
	
}
