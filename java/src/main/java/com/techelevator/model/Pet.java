package com.techelevator.model;

import java.util.List;

public class Pet {
    private int petId;
    private String name;
    private String species;
    private String breed;
    private String weight;
    private String gender;
    private String age;
    private Boolean spayedNeutered;
    private List<String> petDescriptions;
    private List<String> petImageUrls;


    public int getPetId() {
        return petId;
    }

    public void setPetId(int pet_id) {
        this.petId = pet_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getSpayedNeutered() {
        return spayedNeutered;
    }

    public void setSpayedNeutered(Boolean spayNeutered) {
        this.spayedNeutered = spayNeutered;
    }

    public List<String> getPetImageUrls() {
        return petImageUrls;
    }

    public void setPetImageUrls(List<String> petImageUrls) {
        this.petImageUrls = petImageUrls;
    }

    public List<String> getPetDescriptions() {
        return petDescriptions;
    }

    public void setPetDescriptions(List<String> petDescriptions) {
        this.petDescriptions = petDescriptions;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + petId +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", breed=" + breed +
                ", weight=" + weight +
                ", gender=" + gender +
                ", age=" + age +
                ", sprayedNeutered=" + spayedNeutered +
                ", petImageUrls=" + petImageUrls +
                ", petDescriptions=" + petDescriptions +
                '}';
    }
}
