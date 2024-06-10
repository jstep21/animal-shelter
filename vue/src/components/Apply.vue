<template>
  <div id="apply" class="apply-container">
    <form v-on:submit.prevent="apply">
      <h1>Apply To Become a Volunteer!</h1>
      <div class="input-box">
        <div class="form-input-group">
          <label for="firstName">First Name</label>
          <input type="text" id="firstName" v-model="volunteer.firstName"
            required autofocus />
        </div>
        <div class="form-input-group">
          <label for="lastName">Last Name</label>
          <input type="text" id="lastName" v-model="volunteer.lastName"
            required/>
        </div>
        <div class="form-input-group">
          <label for="email">Email</label>
          <input type="email" id="email" v-model="volunteer.email"
            required/>
        </div>
        <div class="form-input-group">
          <label for="phoneNumber">Phone Number</label>
          <input type="tel" id="phoneNumber" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" v-model="volunteer.phoneNumber"
            required/>
        </div>
        <div class="form-input-group">
          <label for="zipCode">Zip Code</label>
          <input type="text" id="zipCode" v-model="volunteer.zipCode"
            required/>
        </div>
        <div class="form-input-group reason_why">
          <label for="reason_why">Tell us more about why you want to be a volunteer!</label>
        </div>
        <div class="form-input-group">
          <textarea id="reason_why" name="reason_why" rows="4" cols="50"></textarea>
        </div>
      </div>
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";
import homePageDogPic from "@/assets/Shelter Dog 2.jpg";

export default {
  components: {},
  data() {
    return {
      volunteer: {
        userId: -1,
        firstName: "",
        lastName: "",
        email: "",
        phoneNumber: "",
        zipCode: "",
        approvalStatus: ""
      },
    };
  },
  methods: {
    apply() {
      const options = {
        headers: {
          'Content-Type': 'application/json',
          'Accept' : 'application/json'
        }
      }
      console.log("in apply() method...");//////

      volunteerService
        .postVolunteer(this.volunteer, options)
        .then((response) => { 

          console.log("POSTed, in .then(), response status is: " + response.status);//////

          // JM - changed this from `if (response.status == 200)` because the actual response I was seeing was 201
          if (response.status >= 200 && response.status < 300) {

            // JM - response.data.token and response.data.user below are coming up in the console as undefined.
            // Here's the response.data object I was getting back from the server:
            // data:
                // approvalStatus: ""
                // email: "jeremy.j.mckeever@gmail.com"
                // firstName: "Joe the Volunteer"
                // lastName: "Test"
                // phoneNumber: "111-111-1111"
                // userId: 22
                // volunteerId: 3018
                // zipCode: "11111"
            // ... so at this point we could store userId but there is no token since adding a volunteer
            //  was done without authentication.

            // commented these out because they were causing issues -- storing an undefined token in local storage
            // this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            // this.$store.commit("SET_USER", response.data.user); 
            
            console.log("should redirect now... response: ", response);//////

            this.$router.push({ name: "home" });
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>

.apply-container {
  height: 100vh;
}
.form-input-group {
  margin-bottom: 0.25rem;
}

label {
  margin-right: 0.25rem;
  color: rgb(43, 98, 134);
}

#login {
  color: rgb(43, 98, 134);
}

h1 {
  font-size: 2rem;
  text-align: center;
  margin-bottom: 0.25rem;
  color: rgb(43, 98, 134);
}

button {
  background-color: rgb(41, 98, 134);
  color: white;
  padding: 0.25rem;
  border-radius: 0.25rem;
  border: none;
  cursor: pointer;
  margin-bottom: 0.5rem;
  text-align: center;
}

button:hover {
  background-color: rgb(36, 93, 129);
  color: rgb(255, 244, 142);
  border-width: 1px;
  border-color: darkblue;
  border-style: solid;
  
}

button:active {
  background-color: rgb(32, 82, 113);
  color: rgba(255, 244, 142, 0.86);
  font-weight: 500;
  border-width: 2px;
  border-color: rgb(31, 78, 107);
  border-style: solid;
}

div {
  display: flex;
  padding: 10px;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0 auto;
  max-width: 17rem;
}

input {
  padding: 0.25rem;
  border-radius: 0.25rem;
  margin: 0.25rem;
  border: 1px solid rgb(43, 98, 134);
}

.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-size: cover;
  background-position: center;
}

.login-container::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-image: url("@/assets/Shelter Dog 2.jpg");
  background-size: cover;
  background-position: center;
  opacity: 0.2;
  z-index: -1;
}

.center-text {
  text-align: center;
}

.custom-link {
  color: rgb(7, 28, 41);
}

.custom-link:hover {
  text-decoration: underline;
}
.input-box {
  display: flex;
  flex-direction: column;
  align-items: center;
}
label {
  font-size: 1.25rem;
}
.form-input-group {
  margin-bottom: 1rem;
}

.reason_why {
  margin-bottom: 0rem;
}

textarea {
  width: 750px;
  height: 150px;
  border: 1px solid rgb(43, 98, 134);
  border-radius: 0.25rem;
}

div.form-input-group {
  display: flex;
  justify-content: center;
  align-items: flex;
}
</style>
