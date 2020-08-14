package com.assignment.mindbow.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.assignment.mindbow.utility.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@Entity
@Table(name = "managers")
@JsonInclude(Include.NON_EMPTY)
public class Manager extends Auditable<String> implements Serializable {

	private static final long serialVersionUID = 8761736705134601432L;

	private static final Logger logger = LogManager.getLogger(Manager.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String firstName;

	
	@Column
	private String lastName;


	@Column(name = "email", nullable = false, unique = true)
	private String email;

	
	
	@Column
	private String password;

	@Column
	private String passwordToken;

	@JsonIgnore
	@Column
	private Date passwordLinkExpireTime;

	
	@Column
	private String address;

	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}







	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordToken() {
		return passwordToken;
	}



	public void setPasswordToken(String passwordToken) {
		this.passwordToken = passwordToken;
	}



	public Date getPasswordLinkExpireTime() {
		return passwordLinkExpireTime;
	}



	public void setPasswordLinkExpireTime(Date passwordLinkExpireTime) {
		this.passwordLinkExpireTime = passwordLinkExpireTime;
	}





	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}




	@Override
	public String toString() {
		String str = "";
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (Exception e) {
			logger.error("Exception in method : " + e.getMessage());
		}
		return str;
	}
	

	

}


