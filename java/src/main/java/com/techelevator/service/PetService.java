package com.techelevator.service;

import com.techelevator.dao.ImageDao;
import com.techelevator.dao.PetDAO;
import com.techelevator.model.PetDescriptionDto;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan("{com.techelevator.service.PetService}")
public class PetService {
    private PetDAO petDao;
    public PetService(PetDAO petdao) {
        this.petDao = petdao;
    }
    public int saveDescriptions(PetDescriptionDto newPetDescriptions) {
        List<String> petDescriptions = newPetDescriptions.getDescriptions();
        int petId = newPetDescriptions.getPetId();
        int rowCount = 0;

        for (String description : petDescriptions) {
            petDao.addPetDescriptions(petId, description);
            rowCount++;
        }
        return rowCount;
    }
}
