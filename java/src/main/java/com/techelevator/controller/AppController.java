package com.techelevator.controller;

import com.techelevator.dao.PetDAO;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.Pet;
import com.techelevator.model.VolunteerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AppController {
    @Autowired
    private PetDAO petDao;
    @Autowired
    private VolunteerDao volunteerDao;

    @PreAuthorize("permitAll")
    @RequestMapping(path="/pets", method = RequestMethod.GET)
    public List<Pet> getAllPets() {
        return petDao.getAllPets();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path="/pets/{id}", method = RequestMethod.GET)
    public Pet getPet(@PathVariable int id) {
        return petDao.getPet(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/add-pet", method = RequestMethod.POST)
    public Pet addPet(@RequestBody Pet pet) {
        return petDao.addPet(pet);
    }

    @PreAuthorize("permitAll") // permitAll for testing only
    @RequestMapping(path="/volunteers", method = RequestMethod.GET)
    public List<VolunteerDto> getAllVolunteers() {
        return volunteerDao.getAllVolunteers();
    }

    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/volunteers", method = RequestMethod.POST)
    public VolunteerDto addVolunteer(@RequestBody VolunteerDto volunteer) {
        return volunteerDao.addVolunteer(volunteer);
    }

}
