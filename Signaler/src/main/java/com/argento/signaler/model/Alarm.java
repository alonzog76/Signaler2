
package com.argento.signaler.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Alarm {

	private int status;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "alarm_id")
	private long alarmId;

	private double latitude;
	private double longitude;
	private long createdTime;
	private long updatedTime;
	private String title;
	private String description;
	private int numberOfSignalations;
	private Integer type;
	private String comments;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "alarm_mobile", joinColumns = {
			@JoinColumn(name = "ALARM_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "MOBILE_ID",
					nullable = false, updatable = false) })
	private Set<Mobile> mobiles = new HashSet<>();

}
