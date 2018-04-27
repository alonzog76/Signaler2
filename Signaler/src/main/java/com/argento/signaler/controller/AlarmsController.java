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

import com.argento.signaler.model.Alarm;
import com.argento.signaler.repository.AlarmsRepository;

@RestController
@RequestMapping("/alarms")
public class AlarmsController {

	
	AlarmsRepository alarmsRepository;
	
	public AlarmsController(AlarmsRepository alarmsRepository) {
		this.alarmsRepository = alarmsRepository;
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Alarm>> getAlarms(){

		List<Alarm> list = new ArrayList<>();
		
		return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body(list);
		
	}

	@PostMapping("/")
	public ResponseEntity<Alarm> createAlarm(Alarm alarm){
		Alarm newAlarm = alarmsRepository.save(alarm);
		
		return ResponseEntity
	            .ok()
	            .body(newAlarm);
	}

	
	@PutMapping("/{alarmId}")
	public ResponseEntity<Alarm> updateAlarm(@PathVariable Long alarmId, @RequestBody Alarm alarm){
		Alarm updatedAlarm = alarmsRepository.save(alarm);
		
		return ResponseEntity
	            .ok()
	            .body(updatedAlarm);
	}
	
	
	@DeleteMapping("/{alarmId}")
	public ResponseEntity<String> deletedAlarm(@PathVariable Long alarmId){
		alarmsRepository.deleteById(alarmId);
		
		return ResponseEntity
	            .ok()
	            .body("Done");
	}
	
	
	
	
	
	
	
}
