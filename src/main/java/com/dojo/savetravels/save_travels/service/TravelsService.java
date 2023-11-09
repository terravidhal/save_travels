package com.dojo.savetravels.save_travels.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.savetravels.save_travels.models.Travels;
import com.dojo.savetravels.save_travels.repositories.TravelsRepository;




@Service
public class TravelsService {
     // adding the Travels repository as a dependency
     private final TravelsRepository travelsRepository;
    
     public TravelsService(TravelsRepository travelsRepository) {
         this.travelsRepository = travelsRepository;
     }

     
     // returns all the travels
     public List<Travels> allTravels() {
         return travelsRepository.findAll();
     }

     // retrieves a travels
     public Travels findTravels(Long id) {

         Optional<Travels> optionalTravels = travelsRepository.findById(id);
         if(optionalTravels.isPresent()) {
             return optionalTravels.get();
         } else {
             return null;
         }
     }
     


     // creates a Travel
     public Travels createTravels(Travels b) {
         return travelsRepository.save(b);
     }

     // update
	public Travels updateTravels(Travels b) {
		return travelsRepository.save(b);
	}
	//delete
	public void deleteTravels(Long id) {
		Optional<Travels> optionalTravels = travelsRepository.findById(id);
		if(optionalTravels.isPresent()) {
			travelsRepository.deleteById(id);
		}
	}
}
