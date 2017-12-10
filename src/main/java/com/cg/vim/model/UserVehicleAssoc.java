package com.cg.vim.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cg.vim.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * The persistent class for the user_vehicle_assoc database table.
 * 
 */
@Entity
@Table(name="user_vehicle_assoc")
@NamedQuery(name="UserVehicleAssoc.findAll", query="SELECT u FROM UserVehicleAssoc u")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="assocId")
public class UserVehicleAssoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="assoc_id")
	private int assocId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dop;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_tsp")
	private Date updTsp;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_name")
	private User user;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="vin")
	private Vehicle vehicle;

	public UserVehicleAssoc() {
		//This is a default constructor
	}

	public int getAssocId() {
		return this.assocId;
	}

	public void setAssocId(int assocId) {
		this.assocId = assocId;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDop() {
		return this.dop;
	}

	public void setDop(Date dop) {
		this.dop = dop;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getUpdTsp() {
		return this.updTsp;
	}

	public void setUpdTsp(Date updTsp) {
		this.updTsp = updTsp;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}