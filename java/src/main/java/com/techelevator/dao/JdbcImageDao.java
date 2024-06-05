package com.techelevator.dao;

import com.techelevator.model.ImageUrl;
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
public class JdbcImageDao implements ImageDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcImageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ImageUrl> getAllImages() {
        List<ImageUrl> imageUrls = new ArrayList<>();
        String sql = "SELECT image_id, image_url FROM images;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                ImageUrl imageUrl = mapRowToImageUrl(results);
                imageUrls.add(imageUrl);
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Data problems");
        }
        return imageUrls;
    }

    private ImageUrl mapRowToImageUrl(SqlRowSet sqlRowSet) {
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setImageId(sqlRowSet.getInt("image_id"));
        imageUrl.setImageUrl(sqlRowSet.getString("image_url"));
        return imageUrl;
    }

//    @Override
//    public Pet getPet(int petId) {
//        Pet pet = new Pet();
//        String sql = "SELECT * FROM pets WHERE pet_id = ?;";
//
//        try {
//            SqlRowSet results = template.queryForRowSet(sql, petId);
//            if (results.next()) {
//                pet = mapRowToPet(results);
//
//                List<String> petDescriptions = getPetDescriptions(pet.getPetId());
//                pet.setPetDescriptions(petDescriptions);
//
//                // Will also need to do the same for images i believe
//
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            System.out.println("Problem connecting to database");
//        } catch (DataIntegrityViolationException e) {
//            System.out.println("Problem with Data Integrity");
//        }
//        return pet;
//    }
//
//    // Mainly used to populate the list of descriptions for each pet
//    // (i think we'll need one for images too)
//    @Override
//    public List<String> getPetDescriptions(int petId) {
//        List<String> petDescriptions = new ArrayList<>();
//        String sql = "SELECT description FROM descriptions " +
//                "JOIN pet_description ON pet_description.description_id = descriptions.description_id " +
//                "WHERE pet_id = ?;";
//
//        try {
//            SqlRowSet results = template.queryForRowSet(sql, petId);
//            while (results.next()) {
//                petDescriptions.add(results.getString("description"));
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            System.out.println("Problem connecting to database");
//        } catch (DataIntegrityViolationException e) {
//            System.out.println("Problem with Data Integrity");
//        }
//        return petDescriptions;
//    };
//
//
//
//    // Havent tested
//    @Override
//    public Pet addPet(Pet petToAdd) {
//        String sql = "INSERT INTO pets " +
//                "(name, species, breed, weight, gender, age, spayed_neutered)" +
//                "VALUES " +
//                "(?, ?, ?, ?, ?, ?, ?) RETURNING pet_id";
//        int newPetId = -1;
//        try {
//            newPetId = template.queryForObject(sql, Integer.class,
//                    petToAdd.getName(),
//                    petToAdd.getSpecies(),
//                    petToAdd.getBreed(),
//                    petToAdd.getWeight(),
//                    petToAdd.getGender(),
//                    petToAdd.getAge(),
//                    petToAdd.getSpayedNeutered()
//            );
//        } catch (CannotGetJdbcConnectionException e) {
//            System.out.println("Problem connecting to database");
//        } catch (DataIntegrityViolationException e) {
//            System.out.println("Problem with Data Integrity");
//        }
//        return getPet(newPetId);
//    };




}

