BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username, password_hash, role) VALUES ('jake-test', '$2a$10$fPgME8wUQW1P1UYGiK2K.OIMK7bUBcbkEyuw81OIFPY94Drlomqxu', 'ROLE_USER')

INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Queso', 'Cat', 'Maine Coon', '15', 'Female', '5', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Big Chew', 'Dog', 'Great Dane', '160', 'Male', '2', true);

INSERT INTO description(description) VALUES ('Playful');
INSERT INTO description(description) VALUES ('Affectionate');
INSERT INTO description(description) VALUES ('Funny');
INSERT INTO description(description) VALUES ('Intelligent');
INSERT INTO description(description) VALUES ('Cute');
INSERT INTO description(description) VALUES ('Independent');
INSERT INTO description(description) VALUES ('Laidback');
INSERT INTO description(description) VALUES ('Energetic');

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

INSERT INTO volunteers(user_id, first_name, last_name, email, phone_number, zip_code, is_approved) VALUES(3, 'Jake', 'Test', 'email@gmail.com', '123-456-7890', '98765', "Pending");


COMMIT TRANSACTION;
