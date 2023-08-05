package com.codingdojo.dojosninjas.services;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	
	//CREAR UN NINJA
	public Ninja crearNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
}
