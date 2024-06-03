BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO pets (name, species, breed, size, gender, age, sprayed_neutered) VALUES ('Queso', 'Cat', 'Maine Coon', 'Large', 'Female', 'Adult', true);
INSERT INTO pets (name, species, breed, size, gender, age, sprayed_neutered) VALUES ('Big Chew', 'Dog', 'Great Dane', 'Large', 'Male', 'Young', true);

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

COMMIT TRANSACTION;
