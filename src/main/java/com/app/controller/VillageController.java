package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dao.VillageDAO;
import com.app.model.Person;
import com.app.model.Village;

@Controller
@RequestMapping("/village")
public class VillageController {
	
	@Autowired
	VillageDAO villageDAO;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	Village getVillage(@PathVariable Integer id) {
		
		Village village = villageDAO.getVillage(id);
		List<Person> villagers = village.getPersons();
		System.out.println("persons size: " + villagers.size());
		for(Person p : villagers) {
			System.out.println("p.getFirstName(): " + p.getFirstName());
		}
		System.out.println("returning village");
		return village;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody
	Village create(@RequestBody Village village) {

		villageDAO.create(village);

		return village;
	}
}
