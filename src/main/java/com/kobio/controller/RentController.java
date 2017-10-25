package com.kobio.controller;



import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kobio.security.PersonService;
import com.kobio.dao.EquipDao;
import com.kobio.model.Equipment;
import com.kobio.model.Person;

/**
*
* @author chidinmaobioha
*
*
*/


@Controller
public class RentController{
	
	@Autowired
	private PersonService PersonService;
	
	@Autowired
	private EquipDao equipdao;
	
	private static final Logger logger = LoggerFactory.getLogger(RentController.class);
	
	@Qualifier(value="PersonService")
	public void setPersonService(PersonService persond)
	{
		this.PersonService = persond;
	}
	
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) throws Exception {
		//equipdao.indexEquipment();  
		map.addAttribute("ser", getPrincipal());
		map.addAttribute("equipments", this.equipdao.getEquipmentsbyUserid(getPrincipal().getID()));
	
			return "menu";
	}
	
		

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(ModelMap model) {
		model.addAttribute("Person", new Person());
		return "signup";
	}
	
	@RequestMapping(value = "/accessdenied")
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}
	
	@RequestMapping(value= "/Person/add", method = RequestMethod.POST)
	public String addPerson(@Valid @ModelAttribute(value = "Person") Person p, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors())
		{
			return "signup";
		}
		else 
		{
			this.PersonService.addPerson(p);
			logger.info("Person added");
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping(value =  "/return/{ID}", method = RequestMethod.GET)
	   public String returnequip(@PathVariable("ID") int id, ModelMap model)
	{
		
			model.addAttribute("equipment", this.equipdao.getEquipmentById(id));
			model.addAttribute("ser", getPrincipal());
			return "rentmeform";
			
	}
	
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	   public String searchPage(ModelMap model)
	   {
	      return "search";
	   }
	
	@RequestMapping(value = "/doSearch", method = RequestMethod.POST)
	   public String search(
	      @RequestParam("searchText")
	      String searchText, ModelMap model
	   ) throws Exception
	   {
		logger.info("string" + searchText);
		
		List<Equipment> foundEquips = new ArrayList<Equipment>();
	      foundEquips = equipdao.searchForEquipment(searchText);
	      
	     if(!foundEquips.isEmpty())
	     {
	       model.addAttribute("foundEquip", foundEquips);
	      return "found";
	      }
	     else
	     {
	    	 return "denied";
	     }
	   }
	
	@RequestMapping(value =  "/rent/{ID}", method = RequestMethod.GET)
	   public String rent(@PathVariable("ID") int id, ModelMap model)
	{
		model.addAttribute("equipment", this.equipdao.getEquipmentById(id));
		model.addAttribute("ser", this.PersonService.getPersonbyPersonname(getPrincipal().getusername()));
		logger.info( " " + id );
		Equipment equip = this.equipdao.getEquipmentById(id);
		if (equip.getborrowed() == 0)
		{
			logger.info("message available");
			return "rentmeform";
		}
		
		return "denied";			
	}
	
	
	
	@RequestMapping(value =  "/rentso", method = RequestMethod.POST)
	   public String rentto (@ModelAttribute("equipment") Equipment e)
	{
	
	this.equipdao.updateEquip(e);
	logger.info( "equipment updated" );
	return "redirect:/menu";
	}
	
	
	//user is not allowed to update role
	@RequestMapping(value= "/person/uppy", method = RequestMethod.POST)
	  public String updatePerson(@ModelAttribute("ser") Person p){
		
		if(p.getID() != 0){
			this.PersonService.updatePerson(p);
			updateprincipal(p);
		}
		else
		{
			logger.info("id = 0");
		}
		
		return "redirect:/menu";
		
	}
	
	@RequestMapping(value =  "/Person/update/{ID}", method = RequestMethod.GET)
	  public String update(@PathVariable("ID") int id, ModelMap model)
	{
		model.addAttribute("ser", this.PersonService.getPersonById(id));
		logger.info("" + id);
		return "updateuser";
		
		
	}
	
	
	// update user authentication details
	public static void updateprincipal(@ModelAttribute("ser") Person p)
	{
		logger.info("print" + p.getusername());
		logger.info("print" +  p.getpassword());
		SecurityContextHolder.getContext().setAuthentication( new UsernamePasswordAuthenticationToken(p.getusername(), p.getpassword()));
	}
	
	//get user authentication details
	 public Person getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	            return this.PersonService.getPersonbyPersonname(userName);
	        } else {
	            return null;
	        } 
	       
	    }
	
	
}
