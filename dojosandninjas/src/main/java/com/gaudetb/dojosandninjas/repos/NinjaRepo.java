
package com.gaudetb.dojosandninjas.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gaudetb.dojosandninjas.models.Ninja;


public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();
	
	@Query("SELECT d.id FROM Ninja d WHERE name = ?1")
	Long getNinjaIdWhereName(String name);
	

}
