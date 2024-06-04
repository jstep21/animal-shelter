------------------------------------------------------
-- Playground file for queries to test out our code --
------------------------------------------------------

SELECT * FROM users;


SELECT * FROM descriptions;
SELECT * FROM pet_description;

SELECT * FROM volunteers;


---- path="/pets" ---- getAllPets() ---- 
SELECT * FROM pets;

---- path="/pets/{id}" ---- Pet getPet(int petId) ---- Pet IDs are from 1000-1999
SELECT * FROM pets WHERE pet_id = 1001;
SELECT * FROM pets WHERE pet_id = 1002;

---- no endpoint ---- List<String> getPetDescriptions(int petId) ---- Pet IDs are from 1000-1999
SELECT p.name, d.description FROM descriptions d
JOIN pet_description pd ON pd.description_id = d.description_id
JOIN pets p ON p.pet_id = pd.pet_id
WHERE p.pet_id = 1002;


