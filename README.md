
# Animal Shelter Capstone Plan
## 1. Development Environment
### Frontend:
* [DONE] Ensure Node.js and Vue are installed.
Set up a new Vue 3 project using Vite.
Install necessary Vue.js libraries and dependencies, including Axios and Vuex.
### Backend:
* [DONE] Set up a new Spring Boot project with Spring 2.
Configure dependencies for Spring Web, Spring Security, PostgreSQL, and JDBC template.
Database:
* [DONE] Install and set up PostgreSQL locally.
Create the database schema and necessary tables.
## 2. Database Schema Design
### Tables:
* Users (user_id, username, password_hash, role)
* Pets (user_id, name, species, breed, weight, gender, age, spayed_neutered, pet_image)
* Description (description_id, description)
* Volunteers (volunteer_id, user_id, first_name, last_name, email, phone_number, zip_code, is_approved)
* [TODO] Images (image_id, image_url)
### Join Tables:
* Pet_Description
* [TODO] Pet_Image
## 3. Backend (Spring Boot)
### Controllers: REST controllers to handle HTTP requests.
* AuthController for login and registration.
* PetController for managing pet listings.
* EmailController for managing sending email.
* [TODO] VolunteerController for handling volunteer applications and volunteer management.
### Services: Business logic 
* UserService
* PetService
* EmailService
* VolunteerService
### DAOs: Data access layer using JDBC template
* UserDAO
* PetDAO
* [TODO] EmailDAO
* VolunteerDAO
### Security
* [DONE] Configure Spring Security with JWT for authentication and authorization.
* [DONE] Define roles and permissions.
## 4. Frontend (Vue.js)
### Components:
* PetList for displaying available pets.
* PetCard for individual pet details.
* VolunteerApplicationForm for submitting applications.
* LoginForm for user login.
* AddPetForm for adding new pet listings.
* UpdatePetForm for updating pet details.
* VolunteerDirectory for listing volunteers and admins.
### Routing:
* Define routes for different views using Vue Router.
* Ensure protected routes for volunteers and administrators.
### State Management:
* Use Vuex to manage application state.
### API Integration:
* Use Axios to interact with the backend services.
## Connecting the Technologies
### Frontend to Backend Communication:
* Use Axios in Vue.js to make HTTP requests to the Spring Boot backend.
* Set up API endpoints in the backend to handle requests from the frontend.
* Ensure CORS is properly configured in Spring Boot to allow requests from the Vue.js frontend.
### Database Interaction:
* Use JDBC template in Spring Boot to interact with PostgreSQL.
Implement DAOs for database operations.
### Authentication and Authorization:
* [DONE] Implement JWT-based authentication in Spring Boot.
* Protect API endpoints with Spring Security.
* Handle token storage and validation on the frontend (store JWT in local storage or cookies).
## Initial Tasks
### Set Up Repositories:
* [DONE] Create Git repositories for frontend and backend.
### Create Database Schema:
* Define tables and relationships.
### Set Up Spring Boot Project:
* [DONE] Initialize a new Spring Boot project.
* [DONE] Configure dependencies and application properties for JDBC template.
* Develop Basic Backend APIs.
* Implement basic CRUD operations for pets and volunteer applications using JDBC template.
* [DONE] Set up authentication endpoints.
### Set Up Vue.js Project:
* Initialize a new Vue 3 project using Vite.
* Create basic components and set up routing.
### Connect Frontend and Backend:
* Implement API calls in Vue.js to interact with Spring Boot backend.
* Ensure proper handling of authentication and authorization.
