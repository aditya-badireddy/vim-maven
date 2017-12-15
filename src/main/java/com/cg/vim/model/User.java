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

import com.cg.vim.util.JsonDateDeserializer;
import com.cg.vim.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="userName")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	private BigInteger mobile;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_tsp")
	private Date updTsp;

	@Id
	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to UserVehicleAssoc
	@Transient
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<UserVehicleAssoc> userVehicleAssocs;

	public User() {
		//This is a default constructor
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDob() {
		return this.dob;
	}
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigInteger getMobile() {
		return this.mobile;
	}

	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getUpdTsp() {
		return this.updTsp;
	}
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setUpdTsp(Date updTsp) {
		this.updTsp = updTsp;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<UserVehicleAssoc> getUserVehicleAssocs() {
		return this.userVehicleAssocs;
	}

	public void setUserVehicleAssocs(Set<UserVehicleAssoc> userVehicleAssocs) {
		this.userVehicleAssocs = userVehicleAssocs;
	}

	public UserVehicleAssoc addUserVehicleAssoc(UserVehicleAssoc userVehicleAssoc) {
		getUserVehicleAssocs().add(userVehicleAssoc);
		userVehicleAssoc.setUser(this);

		return userVehicleAssoc;
	}

	public UserVehicleAssoc removeUserVehicleAssoc(UserVehicleAssoc userVehicleAssoc) {
		getUserVehicleAssocs().remove(userVehicleAssoc);
		userVehicleAssoc.setUser(null);

		return userVehicleAssoc;
	}

}