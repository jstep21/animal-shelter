<template>
  <div class="apply-container">
    <h1 class="apply-header">Apply To Become a Volunteer!</h1>
    <form class="apply-form" v-on:submit.prevent="apply">
      <div class="apply-data-box">
          <label for="firstName">First Name</label>
          <input type="text" id="firstName" v-model="volunteer.firstName"
            required autofocus />
          <label for="lastName">Last Name</label>
          <input type="text" id="lastName" v-model="volunteer.lastName"
            required/>
          <label for="email">Email</label>
          <input type="email" id="email" v-model="volunteer.email"
            required/>
          <label for="phoneNumber">Phone Number</label>
          <input type="text" id="phoneNumber" v-model="volunteer.phoneNumber"
            required/>
          <label for="zipCode">Zip Code</label>
          <input type="text" id="zipCode" v-model="volunteer.zipCode"
            required/>
          <label for="reason_why">Tell us more about why you want to be a volunteer!</label>
          <textarea id="reason_why" name="reason_why" rows="4" cols="50"></textarea>
      </div>
      <div>
        <button type="submit">Submit</button>
      </div>
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
        approvalStatus: "Pending"
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
      // console.log("in apply() method...");//////

      volunteerService
        .postVolunteer(this.volunteer, options)
        .then((response) => { 

           // console.log("POSTed, in .then(), response status is: " + response.status);//////
           if (response.status >= 200 && response.status < 300) {
            alert("Application sent succesfully!")
            // console.log("should redirect now... response: ", response);//////
            this.$router.push({ name: "home" });
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status >= 400) {
            alert("There's a volunteer already associated with this email address"); // this is trigger when someone enters in 
            this.invalidCredentials = true;                                          // an email that's already in the database
          }
        });
    },
  },
};
</script>

<style scoped>
.apply-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: auto;
  width: 100%;
}
.apply-header {
  font-size: 2rem;
  text-align: center;
  margin-top: auto;
  margin-bottom: 100px;
  color: rgb(43, 98, 134);
}
.apply-form {
  display: block;
  grid-template-rows: repeat(2, 1fr);
  align-items: center;
  justify-items: center;
  margin: 0 auto;
  color: rgb(43, 98, 134);
}

.apply-data-box {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  row-gap: 10px;
  align-items: center;
  justify-items: left;
  margin: 0 auto;
  color: rgb(43, 98, 134);
}
.apply-data-box > label {
  display: inline;
  justify-items: right;
  margin: 0 30px 0 auto;
  font-size: 1.25rem;
  color: rgb(43, 98, 134);
}
.apply-data-box > input {
  display: inline;
  justify-items: inherit;
  margin: 0 auto;
  color: black;

  padding: 0.25rem;
  border-radius: 0.25rem;
  margin: 0.25rem;
  border: 1px solid rgb(43, 98, 134);
}
.apply-data-box > textarea {
  display: inline;
  justify-items: left;
  margin: 0 auto;
  color: black;

  padding: 0.25rem;
  border-radius: 0.25rem;
  margin: 0.25rem;
  border: 1px solid rgb(43, 98, 134);
}
.apply-form > button {
  display: inline;
  justify-items: right;
  align-items: right;
  margin: 0 0 auto 0;
  padding: 0.25rem;
  border-radius: 0.25rem;
  border: 1px solid rgb(43, 98, 134);
}

.form-input-group {
  display: contents;
  margin-bottom: 0.25rem;
  margin-right: 0.25rem;
  font-size: 1.25rem;
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

.reason_why {
  margin-bottom: 0rem;
  display: inline;
  justify-items: left;
  margin: 0 auto;
  color: black;

  padding: 0.25rem;
  border-radius: 0.25rem;
  margin: 0.25rem;
  border: 1px solid rgb(43, 98, 134);
}

/* textarea {
  width: 750px;
  height: 150px;
  border: 1px solid rgb(43, 98, 134);
  border-radius: 0.25rem;
} */

/* .form-input-group {
  display: flex;
  align-items: baseline;
  margin-bottom: 10px;
  border-bottom: 1px solid #ddd;
  padding-bottom: 10px;
}

.form-input-group label {
  flex: 1;
  text-align: right;
  padding-right: 10px;
} */

</style>
