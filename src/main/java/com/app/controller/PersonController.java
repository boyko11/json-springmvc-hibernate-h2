package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dao.PersonDAO;
import com.app.model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonDAO personDAO;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	Person getPerson(@PathVariable Integer id) {
		System.out.println("----------------------------------------");
		Person p = personDAO.get(id);
		return p;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody
	Person create(@RequestBody Person person) {

		personDAO.create(person);

		return person;
	}
	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.PUT) public
	 * @ResponseBody Person update(@RequestBody Person person) {
	 * 
	 * Person personToUpdate =
	 * null;//data.get(person.getFirstName().toUpperCase());
	 * personToUpdate.setAge(person.getAge());
	 * personToUpdate.setFirstName(person.getFirstName());
	 * personToUpdate.setLastName(person.getLastName());
	 * 
	 * person.setFirstName(null);
	 * 
	 * return person;//data.get(person.getFirstName().toUpperCase()); }
	 * 
	 * @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE)
	 * public @ResponseBody Person delete(@PathVariable final String name) {
	 * 
	 * Person personToDelete = null;//data.remove(name.toUpperCase()); return
	 * personToDelete; }
	 */

}
