BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
-- The password for this test user is just 'password'
INSERT INTO users (username, password_hash, role) VALUES ('jake-test', '$2a$10$fPgME8wUQW1P1UYGiK2K.OIMK7bUBcbkEyuw81OIFPY94Drlomqxu', 'ROLE_USER');

INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Queso', 'Cat', 'Maine Coon', '15', 'Female', '5', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Big Chew', 'Dog', 'Great Dane', '160', 'Male', '2', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Cloud', 'Rabbit', 'Angora', '30', 'Male', '4', true);


INSERT INTO descriptions(description) VALUES ('Playful');
INSERT INTO descriptions(description) VALUES ('Affectionate');
INSERT INTO descriptions(description) VALUES ('Funny');
INSERT INTO descriptions(description) VALUES ('Intelligent');
INSERT INTO descriptions(description) VALUES ('Cute');
INSERT INTO descriptions(description) VALUES ('Independent');
INSERT INTO descriptions(description) VALUES ('Laid-back');
INSERT INTO descriptions(description) VALUES ('Energetic');
INSERT INTO descriptions(description) VALUES ('People-friendly');
INSERT INTO descriptions(description) VALUES ('Protective');
INSERT INTO descriptions(description) VALUES ('Quirky');
INSERT INTO descriptions(description) VALUES ('Wild');
INSERT INTO descriptions(description) VALUES ('Well-trained');
INSERT INTO descriptions(description) VALUES ('Timid');
INSERT INTO descriptions(description) VALUES ('Mischievous');
INSERT INTO descriptions(description) VALUES ('Wild');
INSERT INTO descriptions(description) VALUES ('Relaxed');
INSERT INTO descriptions(description) VALUES ('Curious');



INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2002);
INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2004);
INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2005);
INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2006);
INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2007);
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2001);
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2002);
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2003);
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2005);
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2008);


INSERT INTO volunteers(user_id, first_name, last_name, email, phone_number, zip_code, is_approved) VALUES(3, 'Jake', 'Test', 'email@gmail.com', '123-456-7890', '98765', 'Pending');


COMMIT TRANSACTION;
