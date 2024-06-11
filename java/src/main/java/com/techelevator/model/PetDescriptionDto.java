package com.techelevator.model;

import java.util.List;

public class PetDescriptionDto {
    private List<String> descriptions;
    private int petId;

    public PetDescriptionDto() {
    }

    public PetDescriptionDto(List<String> descriptions, int petId) {
        this.descriptions = descriptions;
        this.petId = petId;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }
}
