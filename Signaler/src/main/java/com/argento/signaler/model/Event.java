package com.argento.signaler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Event {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "event_id")
	private long eventId;

	private int eventTypeCode;
    String title;
	String description;
    long startTime;
    long endTime;
	double latitude;
	double longitude;
}