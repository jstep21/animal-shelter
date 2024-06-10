BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
-- The password for this test user is just 'password'
INSERT INTO users (username, password_hash, role) VALUES ('jake-test', '$2a$10$fPgME8wUQW1P1UYGiK2K.OIMK7bUBcbkEyuw81OIFPY94Drlomqxu', 'ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('jeremy-test', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER'); -- password is: password
INSERT INTO users (username, password_hash, role) VALUES ('koi-test', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER'); -- password is: password
INSERT INTO users (username, password_hash, role) VALUES ('maria-test', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER'); -- password is: password

INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Queso', 'Cat', 'Maine Coon', '15', 'Female', '5', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Winston Fetchill', 'Dog', 'Great Dane', '160', 'Male', '2', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Gizmo', 'Dog', 'Pug', '16', 'Male', '5', false);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Hercules', 'Dog', 'Great Dane', '135', 'Female', '6', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Sly', 'Dog', 'Australian Cattledog', '42', 'Male', '4', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Koda', 'Dog', 'Dingo', '37', 'Female', '3', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Angus', 'Dog', 'Scottish Deerhound', '95', 'Male', '8', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Lily', 'Dog', 'Maltese', '5', 'Female', '7', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Pippin', 'Dog', 'Yorkshire Terrier', '6', 'Male', '2', false);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Stump', 'Dog', 'Irish Wolfhound', '140', 'Male', '4', true);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Zephyr', 'Dog', 'Italian Greyhound', '15', 'Female', '3', false);
INSERT INTO pets (name, species, breed, weight, gender, age, spayed_neutered) VALUES ('Simba', 'Dog', 'Chow', '60', 'Male', '4', true);
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
INSERT INTO descriptions(description) VALUES ('Good with Young Children');
INSERT INTO descriptions(description) VALUES ('Not Suitable for a Home with Children');
INSERT INTO descriptions(description) VALUES ('Socialized');
INSERT INTO descriptions(description) VALUES ('Socialized with both Dogs and Cats');
INSERT INTO descriptions(description) VALUES ('Needs a Loving Home with no other Pets');
INSERT INTO descriptions(description) VALUES ('Caution: this is a Dingo. Not suitable for a home with babies.');

-- moved pet-description link INSERT statements to the bottom because there are so many of them --

-- inserted the two default users here just to make the User IDs and Volunteer IDs line up: 1, 2, 3 and 3001, 3002, 3003 etc.
INSERT INTO volunteers(user_id, first_name, last_name, email, phone_number, zip_code, approval_status) VALUES(1, 'User', 'Test', 'user@gmail.com', '123-456-7890', '98765', 'Approved');
INSERT INTO volunteers(user_id, first_name, last_name, email, phone_number, zip_code, approval_status) VALUES(2, 'Admin', 'Test', 'admin@gmail.com', '123-456-7890', '98765', 'Approved');
INSERT INTO volunteers(user_id, first_name, last_name, email, phone_number, zip_code, approval_status) VALUES(3, 'Jake', 'Test', 'email@gmail.com', '123-456-7890', '98765', 'Pending');
INSERT INTO volunteers(user_id, first_name, last_name, email, phone_number, zip_code, approval_status) VALUES(4, 'Jeremy', 'Test', 'jeremymck@gmail.com', '123-456-7890', '33186', 'Pending');
INSERT INTO volunteers(user_id, first_name, last_name, email, phone_number, zip_code, approval_status) VALUES(5, 'Koi', 'Test', 'email@gmail.com', '123-456-7890', '98765', 'Pending');
INSERT INTO volunteers(user_id, first_name, last_name, email, phone_number, zip_code, approval_status) VALUES(6, 'Maria', 'Test', 'email@gmail.com', '123-456-7890', '98765', 'Pending');


INSERT INTO images (pet_id, image_url) VALUES (1001, 'https://cdn2.thecatapi.com/images/agwTe5TSe.jpg'); -- Queso
INSERT INTO images (pet_id, image_url) VALUES (1002, 'https://images.dog.ceo/breeds/dane-great/n02109047_16735.jpg'); -- Winston Fetchill
INSERT INTO images (pet_id, image_url) VALUES (1003, 'https://images.dog.ceo/breeds/pug/n02110958_13469.jpg'); -- Gizmo
INSERT INTO images (pet_id, image_url) VALUES (1004, 'https://images.dog.ceo/breeds/dane-great/n02109047_6008.jpg'); -- Hercules
INSERT INTO images (pet_id, image_url) VALUES (1005, 'https://images.dog.ceo/breeds/cattledog-australian/IMG_1211.jpg'); -- Sly
INSERT INTO images (pet_id, image_url) VALUES (1006, 'https://images.dog.ceo/breeds/dingo/n02115641_4737.jpg'); -- Koda
INSERT INTO images (pet_id, image_url) VALUES (1007, 'https://images.dog.ceo/breeds/deerhound-scottish/n02092002_6003.jpg'); -- Angus
INSERT INTO images (pet_id, image_url) VALUES (1008, 'https://images.dog.ceo/breeds/maltese/n02085936_13013.jpg'); -- Lily
INSERT INTO images (pet_id, image_url) VALUES (1009, 'https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_2903.jpg'); -- Pippin
INSERT INTO images (pet_id, image_url) VALUES (1010, 'https://images.dog.ceo/breeds/wolfhound-irish/n02090721_5716.jpg'); -- Stump
INSERT INTO images (pet_id, image_url) VALUES (1011, 'https://images.dog.ceo/breeds/greyhound-italian/n02091032_1121.jpg'); -- Zephyr
INSERT INTO images (pet_id, image_url) VALUES (1012, 'https://images.dog.ceo/breeds/chow/n02112137_5240.jpg'); -- Simba
INSERT INTO images (pet_id, image_url) VALUES (1013, 'https://drive.google.com/file/d/1Khct76VtrVYgNzIS7Q_hEs0ity2zNUzy/view?usp=sharing'); -- Cloud

UPDATE images SET pet_id = 1005 WHERE image_id = 4001; -- Sly
UPDATE images SET pet_id = 1008 WHERE image_id = 4002; -- Lily
UPDATE images SET pet_id = 1010 WHERE image_id = 4003; -- Stump
UPDATE images SET pet_id = 1011 WHERE image_id = 4004; -- Zephyr
UPDATE images SET pet_id = 1007 WHERE image_id = 4005; -- Angus
UPDATE images SET pet_id = 1009 WHERE image_id = 4006; -- Pippin
UPDATE images SET pet_id = 1004 WHERE image_id = 4007; -- Hercules
UPDATE images SET pet_id = 1003 WHERE image_id = 4008; -- Gizmo
UPDATE images SET pet_id = 1012 WHERE image_id = 4009; -- Simba
UPDATE images SET pet_id = 1006 WHERE image_id = 4010; -- Koda


-- Statements below link descriptions to pets --

-- Queso (Pet ID 1001)
INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2002);
INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2004);
INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2005);
INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2006);
INSERT INTO pet_description(pet_id, description_id) VALUES (1001, 2007);

-- Winston Fetchill (Pet ID 1002)
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2001);
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2002);
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2003);
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2005);
INSERT INTO pet_description(pet_id, description_id) VALUES (1002, 2008);


-- Gizmo (Pet ID 1003)
INSERT INTO pet_description(pet_id, description_id) VALUES (1003, 2003);
INSERT INTO pet_description(pet_id, description_id) VALUES (1003, 2017);
INSERT INTO pet_description(pet_id, description_id) VALUES (1003, 2008);
INSERT INTO pet_description(pet_id, description_id) VALUES (1003, 2012);
INSERT INTO pet_description(pet_id, description_id) VALUES (1003, 2022);

-- Hercules (Pet ID 1004)
INSERT INTO pet_description(pet_id, description_id) VALUES (1004, 2004);
INSERT INTO pet_description(pet_id, description_id) VALUES (1004, 2018);
INSERT INTO pet_description(pet_id, description_id) VALUES (1004, 2021);
INSERT INTO pet_description(pet_id, description_id) VALUES (1004, 2011);
INSERT INTO pet_description(pet_id, description_id) VALUES (1004, 2009);

-- Sly (Pet ID 1005)
INSERT INTO pet_description(pet_id, description_id) VALUES (1005, 2015);
INSERT INTO pet_description(pet_id, description_id) VALUES (1005, 2004);
INSERT INTO pet_description(pet_id, description_id) VALUES (1005, 2016);
INSERT INTO pet_description(pet_id, description_id) VALUES (1005, 2001);
INSERT INTO pet_description(pet_id, description_id) VALUES (1005, 2023);

-- Koda (Pet ID 1006)
INSERT INTO pet_description(pet_id, description_id) VALUES (1006, 2005);
INSERT INTO pet_description(pet_id, description_id) VALUES (1006, 2016);
INSERT INTO pet_description(pet_id, description_id) VALUES (1006, 2015);
INSERT INTO pet_description(pet_id, description_id) VALUES (1006, 2007);
INSERT INTO pet_description(pet_id, description_id) VALUES (1006, 2024);

-- Angus (Pet ID 1007)
INSERT INTO pet_description(pet_id, description_id) VALUES (1007, 2006);
INSERT INTO pet_description(pet_id, description_id) VALUES (1007, 2015);
INSERT INTO pet_description(pet_id, description_id) VALUES (1007, 2014);
INSERT INTO pet_description(pet_id, description_id) VALUES (1007, 2002);
INSERT INTO pet_description(pet_id, description_id) VALUES (1007, 2010);

-- Lily (Pet ID 1008)
INSERT INTO pet_description(pet_id, description_id) VALUES (1008, 2022);
INSERT INTO pet_description(pet_id, description_id) VALUES (1008, 2008);
INSERT INTO pet_description(pet_id, description_id) VALUES (1008, 2020);
INSERT INTO pet_description(pet_id, description_id) VALUES (1008, 2017);
INSERT INTO pet_description(pet_id, description_id) VALUES (1008, 2011);

-- Pippin (Pet ID 1009)
INSERT INTO pet_description(pet_id, description_id) VALUES (1009, 2018);
INSERT INTO pet_description(pet_id, description_id) VALUES (1009, 2003);
INSERT INTO pet_description(pet_id, description_id) VALUES (1009, 2014);
INSERT INTO pet_description(pet_id, description_id) VALUES (1009, 2015);
INSERT INTO pet_description(pet_id, description_id) VALUES (1009, 2016);

-- Stump (Pet ID 1010)
INSERT INTO pet_description(pet_id, description_id) VALUES (1010, 2010);
INSERT INTO pet_description(pet_id, description_id) VALUES (1010, 2004);
INSERT INTO pet_description(pet_id, description_id) VALUES (1010, 2021);
INSERT INTO pet_description(pet_id, description_id) VALUES (1010, 2013);
INSERT INTO pet_description(pet_id, description_id) VALUES (1010, 2019);

-- Zephyr (Pet ID 1011)
INSERT INTO pet_description(pet_id, description_id) VALUES (1011, 2012);
INSERT INTO pet_description(pet_id, description_id) VALUES (1011, 2023);
INSERT INTO pet_description(pet_id, description_id) VALUES (1011, 2002);
INSERT INTO pet_description(pet_id, description_id) VALUES (1011, 2009);
INSERT INTO pet_description(pet_id, description_id) VALUES (1011, 2021);

-- Simba (Pet ID 1012)
INSERT INTO pet_description(pet_id, description_id) VALUES (1012, 2014);
INSERT INTO pet_description(pet_id, description_id) VALUES (1012, 2002);
INSERT INTO pet_description(pet_id, description_id) VALUES (1012, 2011);
INSERT INTO pet_description(pet_id, description_id) VALUES (1012, 2019);
INSERT INTO pet_description(pet_id, description_id) VALUES (1012, 2001);

-- Cloud (Pet ID 1013)
INSERT INTO pet_description(pet_id, description_id) VALUES (1013, 2010);
INSERT INTO pet_description(pet_id, description_id) VALUES (1013, 2013);
INSERT INTO pet_description(pet_id, description_id) VALUES (1013, 2021);
INSERT INTO pet_description(pet_id, description_id) VALUES (1013, 2006);
INSERT INTO pet_description(pet_id, description_id) VALUES (1013, 2023);




COMMIT TRANSACTION;
