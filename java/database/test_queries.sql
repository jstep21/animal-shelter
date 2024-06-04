------------------------------------------------------
-- Playground file for queries to test out our code --
------------------------------------------------------

SELECT * FROM users;


SELECT * FROM descriptions;
SELECT * FROM pet_description;

SELECT * FROM volunteers;


---- GET path="/pets" ---- List<Pet> getAllPets() ---- 
SELECT * FROM pets;

---- GET path="/pets/{id}" ---- Pet getPet(int petId) ---- Pet IDs are from 1001-2000
SELECT * FROM pets WHERE pet_id = 1001;
SELECT * FROM pets WHERE pet_id = 1002;

---- no endpoint ---- List<String> getPetDescriptions(int petId) ---- Pet IDs are from 1001-2000
SELECT p.name, d.description FROM descriptions d
JOIN pet_description pd ON pd.description_id = d.description_id
JOIN pets p ON p.pet_id = pd.pet_id
WHERE p.pet_id = 1001;

---- POST path="/add-pet" ---- Pet addPet(Pet petToAdd)  ---- Pet IDs are from 1001-2000
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered)
VALUES
('Joe the Dog', 'Dog', 'Poodle', '40', 'male', '3 years', 'true') RETURNING pet_id;

DELETE FROM pets WHERE name = 'Joe the Dog';

---- GET path="/all-images" ---- List<ImageUrl> getAllImages() ----
--SELECT image_id, image_url FROM images;
