package com.techelevator.controller;

import com.techelevator.dao.PetDAO;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.Pet;
import com.techelevator.model.PetDescriptionDto;
import com.techelevator.model.VolunteerDto;
import com.techelevator.service.EmailService;
import com.techelevator.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private PetService petService;
    @Autowired
    private VolunteerDao volunteerDao;
    @Autowired
    private EmailService emailService;

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

    @PreAuthorize("permitAll")
    @RequestMapping(path="/descriptions", method = RequestMethod.GET)
    public List<String> getDescriptions() {
        return petDao.getDescriptions();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/add-pet", method = RequestMethod.POST)
    public Pet addPet(@RequestBody Pet pet) {
        return petDao.addPet(pet);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/add-pet-descriptions", method = RequestMethod.POST)
    public ResponseEntity<String> addPetDescriptions(@RequestBody PetDescriptionDto petDescriptions) {
        try {
            int rowsAffected = petService.saveDescriptions(petDescriptions);
            if (rowsAffected == petDescriptions.getDescriptions().size()) {
                String message = "List of descriptions added successfully";
                return ResponseEntity.ok(message);
            }
            return ResponseEntity.ok("Not all descriptions added. somethings wrong");
        } catch (Exception e) {
            String errorMessage = "An error occurred";
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PreAuthorize("permitAll") // permitAll for testing only
    @RequestMapping(path="/volunteers", method = RequestMethod.GET)
    public List<VolunteerDto> getAllVolunteers() {
        return volunteerDao.getAllVolunteers();
    }

    // TODO: Error checking. Shouldn't send emails for duplicate volunteer add.
    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/volunteers", method = RequestMethod.POST)
    public VolunteerDto addVolunteer(@RequestBody VolunteerDto volunteer) {
        emailService.sendEmailsWhenAddingNewVolunteer(volunteer);
        return volunteerDao.addVolunteer(volunteer);
    }

}
