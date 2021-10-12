
package com.gaudetb.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaudetb.dojosandninjas.models.Ninja;
import com.gaudetb.dojosandninjas.repos.NinjaRepo;

@Service
public class NinjaService {

	@Autowired
	NinjaRepo ninjaRepo;
	
	public List<Ninja> findAll() {
		return ninjaRepo.findAll();
	}
	
	public Ninja save(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja findOne(Long id) {
		Optional<Ninja> ninjaOptional = ninjaRepo.findById(id);
		if (ninjaOptional.isPresent()) return ninjaOptional.get();
		else return null;
	}
	
	public Long findIdByName(String name) {
		return ninjaRepo.getNinjaIdWhereName(name);
	}
	
	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	}

}
