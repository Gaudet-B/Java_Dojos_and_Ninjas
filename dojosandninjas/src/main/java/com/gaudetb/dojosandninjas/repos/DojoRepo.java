
package com.gaudetb.dojosandninjas.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gaudetb.dojosandninjas.models.Dojo;


public interface DojoRepo extends CrudRepository<Dojo, Long> {
	
	List<Dojo> findAll();
	
//	@Query("SELECT d.id FROM Dojo d WHERE name = ?1")
//	Long getDojoIdWhereName(String name);
	

}
