package com.dojo.savetravels.save_travels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dojo.savetravels.save_travels.models.Travels;
import com.dojo.savetravels.save_travels.service.TravelsService;

import jakarta.validation.Valid;




@Controller
public class TravelsController {
    private final TravelsService travelsService;

    public TravelsController(TravelsService travelsService){
        this.travelsService = travelsService;
    }
    
    //home redirect
    @RequestMapping("/")
    public String index() {
        return "redirect:/travels";
    }

    //home page all travels
    @RequestMapping("/travels")
    public String show_all(Model model) {

        List<Travels> travels = travelsService.allTravels();
        model.addAttribute("travels", travels);
        return "index.jsp";
    }
   
    // details page , specific travel
    @RequestMapping("/travels/{id}")
    public String show_one(@PathVariable("id") Long id,
                            Model model) {
        Travels travel = travelsService.findTravels(id);
        model.addAttribute("travel", travel);
    	return "details.jsp";
    }


    // form page / create new travel
    @RequestMapping("/travel/new")
    public String create_page(@ModelAttribute("travelAttr") Travels travel) { 
        return "travels_form.jsp";
    }


    // processing request create new travel
    @RequestMapping(value="/process_travel", method=RequestMethod.POST)
    public String create_process(@Valid @ModelAttribute("travelAttr") Travels travel, 
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "travels_form.jsp";
        } else {
            travelsService.createTravels(travel);
            return "redirect:/travels";
        }
    }


     // edit details page / specific travel
     @RequestMapping("/travels/{id}/edit")
     public String edit_page(@PathVariable("id") Long id, 
                             Model model) {
         Travels travel = travelsService.findTravels(id);  
         model.addAttribute("travelObj", travel);
         return "edit.jsp";
     }
 
     //  processing request updated specific travel
     @RequestMapping(value="/process_update/travels/{id}", method=RequestMethod.PUT)
     public String edit_process(@Valid @ModelAttribute("travelObj") Travels travel, 
                                BindingResult result,
                                Model model) {
 
         if (result.hasErrors()) {
             //System.out.println("Results++++++++++ : "+result);
             model.addAttribute("travelObj", travel); 
             return "edit.jsp";
         } else {
             travelsService.updateTravels(travel); 
             return "redirect:/travels";
         }
     } 

     // processing request deleted specific travels
    @RequestMapping(value="/travels/{id}/delete", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        travelsService.deleteTravels(id);
        return "redirect:/travels";
    }
}

