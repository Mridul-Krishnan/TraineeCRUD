/**
 * 
 */
package com.trainee.app.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Mri scan
 *
 */
@Entity
@Table(name = "bs_trainees")
public class Trainee {
	
	@Id
	@GeneratedValue
	private int traineeId;
	private String traineeName;
	private String traineeBatch;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "bsId")
	@JsonIgnoreProperties({"bsName","bsLead","trainees"})
	Bsunit bsunit;
	
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeBatch() {
		return traineeBatch;
	}
	public void setTraineeBatch(String traineeBatch) {
		this.traineeBatch = traineeBatch;
	}
	
	public Trainee() {
		// TODO Auto-generated constructor stub
	}
	public Bsunit getBsunit() {
		return bsunit;
	}
	public void setBsunit(Bsunit bsunit) {
		this.bsunit = bsunit;
	}
	public Trainee(String traineeName, String traineeBatch, Bsunit bsunit) {
		super();
		this.traineeName = traineeName;
		this.traineeBatch = traineeBatch;
		this.bsunit = bsunit;
	}
	public Trainee(int traineeId, String traineeName, String traineeBatch, Bsunit bsunit) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeBatch = traineeBatch;
		this.bsunit = bsunit;
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", traineeBatch=" + traineeBatch
				+ ", bsunit=" + bsunit.getBsId() + "]";
	}
	
	
	
	

}
