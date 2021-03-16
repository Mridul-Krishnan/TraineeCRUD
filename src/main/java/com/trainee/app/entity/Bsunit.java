/**
 * 
 */
package com.trainee.app.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Mri scan
 *
 */

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "bsId")
public class Bsunit {
	
	@Id
	private int bsId;
	private String bsName;
	private String bsLead;
	
	@OneToMany(mappedBy = "bsunit", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"traineeName","traineeBatch","bsunit"})
	private Set<Trainee> trainees = new HashSet<Trainee>();

	public int getBsId() {
		return bsId;
	}

	public void setBsId(int bsId) {
		this.bsId = bsId;
	}

	public String getBsName() {
		return bsName;
	}

	public void setBsName(String bsName) {
		this.bsName = bsName;
	}

	public String getBsLead() {
		return bsLead;
	}

	public void setBsLead(String bsLead) {
		this.bsLead = bsLead;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}
	
	public void addTrainees(Trainee trainee)
	{
		trainee.setBsunit(this);
		this.trainees.add(trainee);
	}

	public Bsunit(int bsId, String bsName, String bsLead, Set<Trainee> trainees) {
		super();
		this.bsId = bsId;
		this.bsName = bsName;
		this.bsLead = bsLead;
		this.trainees = trainees;
	}
	
	public Bsunit() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bsunit [bsId=" + bsId + ", bsName=" + bsName + ", bsLead=" + bsLead + ", trainees=" + trainees.stream().map(i->i.getTraineeId()).collect(Collectors.toList()) + "]";
	}
	
	
}
