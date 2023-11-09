package com.dojo.savetravels.save_travels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.savetravels.save_travels.models.Travels;
import com.dojo.savetravels.save_travels.service.TravelsService;





@RestController
public class TravelsApi {
    private final TravelsService travelsService;

    public TravelsApi(TravelsService travelsService){
        this.travelsService = travelsService;
    }
    
    //return all Travels
    @RequestMapping("/api/travels")
    public List<Travels> index() {
        return travelsService.allTravels();
    }

    //return One specific Travel
    @RequestMapping("/api/travels/{id}")
    public Travels show(@PathVariable("id") Long id) {
        Travels Travels = travelsService.findTravels(id);
        return Travels;
    }


    //create Travels
    @RequestMapping(value="/api/travels", method=RequestMethod.POST)
    public Travels create(@RequestParam(value="expense") String expense, 
                         @RequestParam(value="vendor") String vendor, 
                         @RequestParam(value="amount") Integer amount, 
                         @RequestParam(value="desc") String description) {
        Travels Travels = new Travels(expense, vendor, amount, description);
        return travelsService.createTravels(Travels);
    }

    

    // update
	@RequestMapping(value="/api/travels/{id}", method=RequestMethod.PUT)
    public Travels update(@PathVariable("id") Long id, 
                       @RequestParam(value="expense") String expense, 
                       @RequestParam(value="vendor") String vendor, 
                       @RequestParam(value="amount") Integer amount, 
                       @RequestParam(value="desc") String description) {
        Travels Travels = new Travels(expense, vendor, amount, description);
        Travels.setId(id);
        return travelsService.updateTravels(Travels);
    }
    
    // delete
    @RequestMapping(value="/api/travels/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        travelsService.deleteTravels(id);
    }
}
