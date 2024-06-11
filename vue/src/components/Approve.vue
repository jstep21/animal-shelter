<template>
  <div id="approve-component" class="approve-container">
    <table id="pending-volunteers-table">
      <thead>
        <tr>
          <th>Volunteer ID</th>
          <th>User ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Phone Number</th>
          <th>Zip Code</th>
          <th>Approval Status</th>
          <th hidden>button-approve</th>
          <th hidden>button-decline</th>
        </tr>
      </thead>

      <!-- v-if="volunteer.approvalStatus === 'Pending'"> -->

      <tbody>
        <tr v-for="volunteer in volunteers" :key="volunteer.volunteerId"> 
          <td>{{ volunteer.volunteerId }}</td>
          <td>{{ volunteer.userId }}</td>
          <td>{{ volunteer.firstName }}</td>
          <td>{{ volunteer.lastName }}</td>
          <td>{{ volunteer.email }}</td>
          <td>{{ volunteer.phoneNumber }}</td>
          <td>{{ volunteer.zipCode }}</td>
          <td>{{ volunteer.approvalStatus }}</td>
          <td>
            <button class="approve-button" @click="approve">
              Approve
            </button>
          </td>
          <td>
            <button class="decline-button" @click="decline">
              Decline
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";
import homePageDogPic from "@/assets/Shelter Dog 2.jpg";

export default {
  components: {},
  data() {
    return {
      volunteers: []
    };
  },
  methods: {
    fetchVolunteers() {
      volunteerService
        .getAllVolunteers()
        .then((response) => {
          this.volunteers = response.data
          console.log(this.volunteers);
        })
        .catch((error) => {
          console.error("Error fetching volunteers: ", error);
        });
    },
    approve() {
      this.adjudicate("Approved");
    },
    decline() {
      this.adjudicate("Declined");
    },
    adjudicate(decision) {
      const options = {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
      };
      console.log("in adjudicate() method..."); //////
      console.log("decision: ", decision); //////

      volunteerService
        .updateVolunteer(this.volunteer, options)
        .then((response) => {
          console.log(
            "PUT completed, in .then(), response status is: " + response.status
          ); //////

          if (response.status >= 200 && response.status < 300) {
            // this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            // this.$store.commit("SET_USER", response.data.user);

            console.log("should redirect to home now... response: ", response); //////

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
  created() {
    this.fetchVolunteers();
  }
};
</script>

<style scoped>
.approve-container {
  height: 10vh;
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

#pending-volunteers-table {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0 auto;
  max-width: 17rem;
  color: rgb(43, 98, 134);
  font-size:large;
}
#pending-volunteers-table > thead {
  color: rgb(43, 98, 134);;
  margin: 10px;
  padding: 10px;
  width: 80vw;
}
#pending-volunteers-table > thead > tr {
  display: flex;
  justify-content: space-between;
}
#pending-volunteers-table > tbody {
  color: rgb(43, 98, 134);;
  margin: 10px;
  padding: 10px;
  width: 80vw;
}
#pending-volunteers-table > tbody > tr {
  display: flex;
  justify-content: space-between;
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
