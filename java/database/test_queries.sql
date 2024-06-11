------------------------------------------------------
-- Playground file for queries to test out our code --
------------------------------------------------------

SELECT * FROM users;


SELECT * FROM descriptions;
SELECT * FROM pet_description;

SELECT * FROM volunteers;


---- GET path="/pets" ---- List<Pet> getAllPets() ---- 
SELECT * FROM pets;

SELECT name, breed, image_url FROM pets p
JOIN images i ON p.pet_id = i.pet_id;

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

---- DELETE from pets
DELETE FROM pets WHERE name = 'Joe the Dog';

---- GET path="/volunteers" ---- List<VolunteerDto> getAllVolunteers() ---- 
SELECT * FROM volunteers;

SELECT u.user_id, volunteer_id, first_name, last_name, email, v.approval_status, role 
FROM volunteers v
JOIN users u ON v.user_id = u.user_id;

---- POST path="/volunteers" ---- VolunteerDto addVolunteer(VolunteerDto volunteerToAdd)  ---- Volunteer IDs are from 3001-4000
WITH user_insert AS (
    INSERT INTO users (username, password_hash, role)
    	VALUES ('joe-test', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER')
    	RETURNING user_id
)
INSERT INTO volunteers (user_id, first_name, last_name, email, phone_number, zip_code, approval_status)
	SELECT user_id, 'Joe the Volunteer', 'TestAdded', 'joe@volunteer.org', '999-999-9999', '20007', 'Pending'
	FROM user_insert
	RETURNING volunteer_id;

---- PUT path="/volunteers" ---- VolunteerDto updateVolunteer(VolunteerDto volunteerToUpdate)  ---- Volunteer IDs are from 3001-4000
INSERT INTO volunteers (volunteer_id, user_id, first_name, last_name, email, phone_number, zip_code, approval_status)
    VALUES (3004, 4, 'Jeremy', 'Test', 'jeremymck@gmail.com', '123-456-7890', '33186', 'Approved');

---- DELETE from volunteers and also make sure to delete the linked user
DO $$
DECLARE v_user_id INT;
BEGIN
    DELETE FROM volunteers WHERE first_name = 'Joe the Volunteer' RETURNING user_id INTO v_user_id;
    DELETE FROM users WHERE user_id = v_user_id;
END $$;


---- GET path="/all-images" ---- List<ImageUrl> getAllImages() ----
SELECT image_id, image_url FROM images;
