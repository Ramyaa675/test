package com.skillenza.parkinglotjava;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ParkingLot {
	
    //your code goes here
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false ,columnDefinition = "Long default Null")
	private java.lang.Long id;
	
	   public java.lang.Long getId()
	    {
	        return this.id;
	    }

	    public void setId(java.lang.Long id)
	    {
	        this.id = id;
	    }
	
	@Column(name = "created_at", nullable = false )
	private LocalDateTime created_at;
	
	   public LocalDateTime getCreatedAt()
	    {
	        return this.created_at;
	    }

	public void setCreatedAt(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	@Column(name = "lot", nullable = false ,unique=true,columnDefinition = "INT(11) default Null")
	private int lot;
	
	@Column(name = "parking_amount", nullable = false ,columnDefinition = "INT(11) default Null")
	private int parking_amount;
	
	@Column(name = "parking_duration", nullable = false ,columnDefinition = "INT(11) default Null")
	private int parking_duration;
	
	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public int getParking_amount() {
		return parking_amount;
	}

	public void setParking_amount(int parking_amount) {
		this.parking_amount = parking_amount;
	}

	public int getParking_duration() {
		return parking_duration;
	}

	public void setParking_duration(int parking_duration) {
		this.parking_duration = parking_duration;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public int getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(int vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	@Column(name = "updated_at", nullable = false )
	private LocalDateTime updated_at;
	
	@Column(name = "parking_duration", unique=true,nullable = false ,columnDefinition = "INT(11) default Null")
	private int vehicle_number;
}
