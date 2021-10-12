
package com.gaudetb.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaudetb.dojosandninjas.models.Dojo;
import com.gaudetb.dojosandninjas.repos.DojoRepo;

@Service
public class DojoService {

	@Autowired
	DojoRepo dojoRepo;
	
	public List<Dojo> findAll() {
		return dojoRepo.findAll();
	}
	
	public Dojo save(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo findOne(Long id) {
		Optional<Dojo> dojoOptional = dojoRepo.findById(id);
		if (dojoOptional.isPresent()) return dojoOptional.get();
		else return null;
	}
	
//	public Long findIdByName(String name) {
//		return dojoRepo.getDojoIdWhereName(name);
//	}
	
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	}

}
