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
        pet.setSize(sqlRowSet.getString("size"));
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
                pets.add(pet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Data problems");
        }
        return pets;
    }
}
