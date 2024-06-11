package com.techelevator.dao;

import com.techelevator.model.Pet;
import com.techelevator.model.PetDescriptionDto;

import java.util.List;

public interface PetDAO {
    public List<Pet> getAllPets();

    public Pet getPet(int petId);

    public List<String> getPetDescriptions(int petId);
    public List<String> getDescriptions();

    public List<String> getPetImageUrls(int petId);

    public Pet addPet(Pet petToAdd);
    public boolean addPetDescriptions(int petId, String description);

}
