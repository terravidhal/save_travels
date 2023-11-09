package com.dojo.savetravels.save_travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.savetravels.save_travels.models.Travels;



@Repository
public interface TravelsRepository extends CrudRepository<Travels, Long> { 
	
	//  cette méthode récupère tous les livres de la base de données 
         List<Travels> findAll();
}
