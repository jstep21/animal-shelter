package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDAO {
    private JdbcTemplate template;

    public JdbcPetDao(DataSource ds) {
        template = new JdbcTemplate(ds);
    }
    private Pet mapRowToPet(SqlRowSet sqlRowSet) {
        Pet pet = new Pet();

        pet.setPetId(sqlRowSet.getInt("pet_id"));
        pet.setName(sqlRowSet.getString("name"));
        pet.setSpecies(sqlRowSet.getString("species"));
        pet.setBreed(sqlRowSet.getString("breed"));
        pet.setWeight(sqlRowSet.getString("weight"));
        pet.setGender(sqlRowSet.getString("gender"));
        pet.setAge(sqlRowSet.getString("age"));
        pet.setSpayedNeutered(sqlRowSet.getBoolean("spayed_neutered"));

        return pet;
    }


    @Override
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets";

        try {
            SqlRowSet results = template.queryForRowSet(sql);
            while (results.next()) {
                Pet pet = mapRowToPet(results);

                List<String> petDescriptions = getPetDescriptions(pet.getPetId());
                pet.setPetDescriptions(petDescriptions);

                // Will also need to do the same for images i believe

                pets.add(pet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Data problems");
        }
        return pets;
    }

    @Override
    public Pet getPet(int petId) {
        Pet pet = new Pet();
        String sql = "SELECT * FROM pets WHERE pet_id = ?;";

        try {
            SqlRowSet results = template.queryForRowSet(sql, petId);
            if (results.next()) {
                pet = mapRowToPet(results);

                List<String> petDescriptions = getPetDescriptions(pet.getPetId());
                pet.setPetDescriptions(petDescriptions);

                // Will also need to do the same for images i believe

            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting to database");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Problem with Data Integrity");
        }
        return pet;
    }

    // Mainly used to populate the list of descriptions for each pet
    // (i think we'll need one for images too)
    @Override
    public List<String> getPetDescriptions(int petId) {
        List<String> petDescriptions = new ArrayList<>();
        String sql = "SELECT description FROM descriptions " +
                "JOIN pet_description ON pet_description.description_id = descriptions.description_id " +
                "WHERE pet_id = ?;";

        try {
            SqlRowSet results = template.queryForRowSet(sql, petId);
            while (results.next()) {
                petDescriptions.add(results.getString("description"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting to database");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Problem with Data Integrity");
        }
        return petDescriptions;
    };



    // Havent tested
    @Override
    public Pet addPet(Pet petToAdd) {
        String sql = "INSERT INTO pets " +
                "(name, species, breed, weight, gender, age, spayed_neutered)" +
                "VALUES " +
                "(?, ?, ?, ?, ?, ?, ?) RETURNING pet_id";
        int newPetId = -1;
        try {
            newPetId = template.queryForObject(sql, Integer.class,
                    petToAdd.getName(),
                    petToAdd.getSpecies(),
                    petToAdd.getBreed(),
                    petToAdd.getWeight(),
                    petToAdd.getGender(),
                    petToAdd.getAge(),
                    petToAdd.getSpayedNeutered()
            );
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting to database");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Problem with Data Integrity");
        }
        return getPet(newPetId);
    };
}

