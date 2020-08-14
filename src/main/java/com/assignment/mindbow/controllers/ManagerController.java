package com.assignment.mindbow.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assignment.mindbow.entities.Manager;
import com.assignment.mindbow.exceptions.DataNotValidException;
import com.assignment.mindbow.services.ManagerService;
import com.assignment.mindbow.utility.Response;

@RestController
@RestControllerAdvice
@RequestMapping(path = "/manager")
public class ManagerController {

	  
	   @Autowired
	    private ManagerService managerService;

	   @PostMapping(path= "/create", consumes = "application/json", produces = "application/json")
	   public ResponseEntity<Response> createManager(@RequestBody Manager manager) throws DataNotValidException {
			Response response = new Response();
			 managerService.save(manager);
	
			return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
		}
	   
}
