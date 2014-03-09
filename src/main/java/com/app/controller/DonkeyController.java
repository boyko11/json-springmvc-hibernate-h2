package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dao.DonkeyDAO;
import com.app.model.Donkey;

@Controller
@RequestMapping("/donkey")
public class DonkeyController {

	@Autowired
	DonkeyDAO donkeyDAO;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	Donkey getDonkey(@PathVariable int id) {

		return donkeyDAO.get(id);
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody
	Donkey create(@RequestBody Donkey donkey) {

		donkeyDAO.create(donkey);

		return donkey;
	}
	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.PUT) public
	 * @ResponseBody Donkey update(@RequestBody Donkey donkey) {
	 * 
	 * Donkey donkeyToUpdate = donkeyRecords.get(donkey.getId());
	 * donkeyToUpdate.setAge(donkey.getAge());
	 * donkeyToUpdate.setName(donkey.getName());
	 * donkeyToUpdate.setTemper(donkey.getTemper());
	 * 
	 * return donkeyRecords.get(donkeyToUpdate.getId()); }
	 * 
	 * @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	 * public @ResponseBody Donkey delete(@PathVariable final String id) {
	 * 
	 * Donkey personToDelete = donkeyRecords.remove(id); return personToDelete;
	 * }
	 */

}
