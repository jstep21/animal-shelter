BEGIN TRANSACTION;

DROP TABLE IF EXISTS pet_description;
DROP TABLE IF EXISTS users, pets, description, volunteers;
DROP SEQUENCE IF EXISTS seq_pet_id, seq_description_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1
  MAXVALUE 1000;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

---- PUT TABLE CREATION STATEMENTS HERE
CREATE SEQUENCE seq_pet_id
  INCREMENT BY 1
  START WITH 1001
  MAXVALUE 2000;

CREATE TABLE pets (
    pet_id int NOT NULL DEFAULT nextval('seq_pet_id'),
    name VARCHAR(50) NOT NULL,
    species VARCHAR(50) NOT NULL,
    breed VARCHAR(50) NOT NULL,
	size VARCHAR(50),
	gender VARCHAR(50),
	age VARCHAR(50) NOT NULL,
	spayed_neutered BOOLEAN NOT NULL,
	pet_image VARCHAR(50),
	CONSTRAINT pk_pets PRIMARY KEY (pet_id)
);

CREATE SEQUENCE seq_description_id
  INCREMENT BY 1
  START WITH 2001
  MAXVALUE 3000;

CREATE TABLE description (
    description_id int NOT NULL DEFAULT nextval('seq_description_id'),
    description VARCHAR(50) NOT NULL,
    CONSTRAINT pk_description PRIMARY KEY (description_id)
);

CREATE TABLE pet_description (
    pet_id INT,
    description_id INT,
    CONSTRAINT pk_pet_description PRIMARY KEY (pet_id, description_id),
    CONSTRAINT fk_pet_id FOREIGN KEY (pet_id) REFERENCES pets(pet_id),
    CONSTRAINT fk_description_id FOREIGN KEY (description_id) REFERENCES description(description_id)
);

CREATE SEQUENCE seq_volunteer_id
  INCREMENT BY 1
  START WITH 3001
  MAXVALUE 4000;

CREATE TABLE volunteers (
    volunteer_id int NOT NULL DEFAULT nextval('seq_volunteer_id'),
    user_id int NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50) NOT NULL,
    zip_code INT NOT NULL,
    -- CAN ADD MORE BASED ON APPLICATION FORM
    CONSTRAINT pk_volunteers PRIMARY KEY (volunteer_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

COMMIT TRANSACTION;
