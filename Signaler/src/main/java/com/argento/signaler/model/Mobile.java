/*
 * 
 */
package com.argento.signaler.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mobile {
	
	@Id
	private String mobileId;
	private int raisedAlarmsNo;
	
	
	@ManyToMany(mappedBy="mobiles")
	private Set<Alarm> alarms = new HashSet<>();
}
