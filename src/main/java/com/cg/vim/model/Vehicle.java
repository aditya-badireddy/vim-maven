package com.cg.vim.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cg.vim.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="vin")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String vin;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dom;

	private String model;

	private BigInteger price;

	private String manufacturer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_tsp")
	private Date updTsp;

	@Transient
	@OneToMany(mappedBy="vehicle",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<UserVehicleAssoc> userVehicleAssocs;

	public Vehicle() {
		//This is a default constructor
	}

	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDom() {
		return this.dom;
	}

	public void setDom(Date dom) {
		this.dom = dom;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigInteger getPrice() {
		return this.price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getUpdTsp() {
		return this.updTsp;
	}

	public void setUpdTsp(Date updTsp) {
		this.updTsp = updTsp;
	}

	public Set<UserVehicleAssoc> getUserVehicleAssocs() {
		return this.userVehicleAssocs;
	}

	public void setUserVehicleAssocs(Set<UserVehicleAssoc> userVehicleAssocs) {
		this.userVehicleAssocs = userVehicleAssocs;
	}

	public UserVehicleAssoc addUserVehicleAssoc(UserVehicleAssoc userVehicleAssoc) {
		getUserVehicleAssocs().add(userVehicleAssoc);
		userVehicleAssoc.setVehicle(this);

		return userVehicleAssoc;
	}

	public UserVehicleAssoc removeUserVehicleAssoc(UserVehicleAssoc userVehicleAssoc) {
		getUserVehicleAssocs().remove(userVehicleAssoc);
		userVehicleAssoc.setVehicle(null);

		return userVehicleAssoc;
	}

}