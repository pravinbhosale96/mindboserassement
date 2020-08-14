package com.assignment.mindbow.utility;

import java.io.Serializable;

import javax.persistence.Transient;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Identity extends JSONObject implements JsonEntity, Serializable {

	private static final long serialVersionUID = -3042591524281652621L;

	@JsonIgnore
	protected String token;

	@Transient
	@JsonIgnore
	protected ObjectMapper mapper;

	public Identity() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/*
	 * public void copyProperties(Identity identity, Identity identity1) throws
	 * IllegalAccessException, InvocationTargetException {
	 * org.apache.commons.beanutils.BeanUtils.copyProperties(identity,
	 * identity1); }
	 */
}
