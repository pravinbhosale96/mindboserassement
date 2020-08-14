package com.assignment.mindbow.services;


import java.sql.SQLDataException;
import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.PropertySource;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignment.mindbow.entities.Manager;
import com.assignment.mindbow.exceptions.DataNotValidException;
import com.assignment.mindbow.repositories.ManagerRepository;
import com.assignment.mindbow.utility.Response;
import com.assignment.mindbow.utility.UtilityMethods;


@Service
@PropertySource(value = { "classpath:application.properties" }, ignoreResourceNotFound = true)
public class ManagerServiceImpl implements UserDetailsService,ManagerService {

	Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ManagerRepository managerRepository;
	
	protected String sendEmailEnable;

	public List<Manager> findAll() {
		return managerRepository.findAll();
	}
	
	public Manager findOne(Long id) {
	    Manager manager=null;
		
		return manager;
	}

	public Response save(Manager manager) throws DataNotValidException
	{
		Response response=new Response();
		String managerPassword=manager.getPassword();
		if(!UtilityMethods.isNullOrEmpty(managerPassword))
		{
			logger.info("Password "+managerPassword);
			manager.setPassword(passwordEncoder.encode(managerPassword));
			managerRepository.save(manager);
			response.setStatus(200);
			response.setStatusMessage("Manager created");
		}
		else
		{
			throw new DataNotValidException("Password is missing please provide password");
		}
			
		return response;
	}
	public void delete(Long id)
	{
		managerRepository.deleteById(id);
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Manager user = managerRepository.findOneByEmail(email);
		logger.info(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
	
		Date date = null;
		try {
			date =new Date();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(0, new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				grantedAuthorities);
	}

	
	
}
