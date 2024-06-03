------------------------------------------------------
-- Playground file for queries to test out our code --
------------------------------------------------------

--------------------- (For reference: from schema.sql)
-- CREATE TABLE users (
-- 	user_id SERIAL,
-- 	username varchar(50) NOT NULL UNIQUE,
-- 	password_hash varchar(200) NOT NULL,
-- 	role varchar(50) NOT NULL,
-- 	CONSTRAINT PK_user PRIMARY KEY (user_id)
-- );

--------------------- (For reference: from data.sql)
-- INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
-- INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


SELECT * FROM users;
