package com.techelevator.controller;

import com.techelevator.dao.PetDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.*;
import com.techelevator.service.EmailService;
import com.techelevator.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
    private UserDao userDao;
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
    // TODO: Don't allow duplicate email addresses. These are used as usernames
    //    so duplicates cause a data integrity error.
    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/volunteers", method = RequestMethod.POST)
    public VolunteerDto addVolunteer(@RequestBody VolunteerDto volunteer) {
        emailService.sendEmailsWhenAddingNewVolunteer(volunteer);
        return volunteerDao.addVolunteer(volunteer);
    }

    @PreAuthorize("permitAll") // for testing -- remove this later
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/volunteers", method = RequestMethod.PUT)
    public VolunteerDto updateVolunteer(@RequestBody VolunteerDto volunteer) {
        emailService.sendEmailToApprovedOrDeclinedVolunteer(volunteer);
        return volunteerDao.updateVolunteer(volunteer);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path="/update-password", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePassword(@RequestBody RegisterUserDto user) {
        try {
            boolean response = userDao.updatePassword(user);
            if (response) {
                return ResponseEntity.status(HttpStatus.OK).body("Password Successfully Updated");
            }
            else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user database");
            }
        } catch (Exception e) {
            String errorMessage = "An error occurred with the server";
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
