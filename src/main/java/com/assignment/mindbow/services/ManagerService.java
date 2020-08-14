package com.assignment.mindbow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.mindbow.entities.Manager;
import com.assignment.mindbow.exceptions.DataNotValidException;
import com.assignment.mindbow.utility.Response;


public interface ManagerService {

	public List<Manager> findAll();
	
	public Manager findOne(Long id);

	public Response save(Manager manager) throws DataNotValidException;
	
	public void delete(Long id);
	
	
}
