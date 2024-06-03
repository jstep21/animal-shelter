package com.techelevator.model;

public class Pet {
    private int pet_id;
    private String name;
    private String species;
    private String breed;
    private String size;
    private String gender;
    private String age;
    private Boolean sprayed_neutered;

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public Boolean getSprayed_neutered() {
        return sprayed_neutered;
    }

    public void setSprayed_neutered(Boolean spray_neutered) {
        this.sprayed_neutered = spray_neutered;
    }
    @Override
    public String toString() {
        return "Pet{" +
                "id=" + pet_id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", breed=" + breed +
                ", size=" + size +
                ", gender=" + gender +
                ", age=" + age +
                ", sprayed_neutered=" + sprayed_neutered +
                '}';
    }
}
