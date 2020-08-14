
package com.assignment.mindbow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.mindbow.entities.Manager;




public interface ManagerRepository extends JpaRepository<Manager, Long>{

	Manager findOneByEmail(String email);
}
