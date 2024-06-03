package com.techelevator.controller;

import com.techelevator.dao.PetDAO;
import com.techelevator.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AppController {
    @Autowired
    private PetDAO petDao;

    @PreAuthorize("permitAll")
    @RequestMapping(path="/pets", method = RequestMethod.GET)
    public List<Pet> getAllPets() {
        return petDao.getAllPets();
    }
}
