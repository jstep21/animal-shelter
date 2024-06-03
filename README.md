# Final Capstone
​
This directory contains all of the starter projects for the final capstone.
​
Each project contains instructions that provides information about the starting code and explains how to get started with the final capstone project.

# Animal Shelter Capstone Plan
## 1. Setting Up the Development Environment
### Frontend:
* Ensure Node.js and Vue CLI are installed.
Set up a new Vue 3 project using Vite.
Install necessary Vue.js libraries and dependencies, including Axios and Vuex.
### Backend:
* Set up a new Spring Boot project with Spring 2.
Configure dependencies for Spring Web, Spring Security, PostgreSQL, and JDBC template.
Database:
* Install and set up PostgreSQL locally.
Create the database schema and necessary tables.
## 2. Designing the Database Schema
### Tables:
* Users (id, username, password, role)
* Pets (id, name, species, breed, age, photo_url, status, adopter_info)
* Volunteer Applications (id, applicant_name, contact_info, status)
* Volunteers (id, user_id, name, contact_info)
## 3. Building the Backend (Spring Boot)
### Controllers: REST controllers to handle HTTP requests.
* AuthController for login and registration.
* PetController for managing pet listings.
* VolunteerController for handling volunteer applications and volunteer management.
### Services: Business logic 
* UserService
* PetService
* VolunteerService
### DAOs: Data access layer using JDBC template
* UserDAO
* PetDAO
* VolunteerDAO
### Security
* Configure Spring Security with JWT for authentication and authorization.
* Define roles and permissions.
## 4. Building the Frontend (Vue.js)
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
Database Interaction:
* Use JDBC template in Spring Boot to interact with PostgreSQL.
Implement DAOs for database operations.
### Authentication and Authorization:
* Implement JWT-based authentication in Spring Boot.
* Protect API endpoints with Spring Security.
* Handle token storage and validation on the frontend (store JWT in local storage or cookies).
## Initial Tasks
### Set Up Repositories:
* Create Git repositories for frontend and backend.
### Create Database Schema:
* Define tables and relationships.
### Set Up Spring Boot Project:
* Initialize a new Spring Boot project.
* Configure dependencies and application properties for JDBC template.
* Develop Basic Backend APIs:
* Implement basic CRUD operations for pets and volunteer applications using JDBC template.
* Set up authentication endpoints.
### Set Up Vue.js Project:
* Initialize a new Vue 3 project using Vite.
* Create basic components and set up routing.
### Connect Frontend and Backend:
* Implement API calls in Vue.js to interact with Spring Boot backend.
* Ensure proper handling of authentication and authorization.
