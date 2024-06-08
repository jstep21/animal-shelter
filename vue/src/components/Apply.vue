<template>
  <div id="apply" class="apply-container">
    <h1>Apply component -- Edit me!!</h1>

    <form v-on:submit.prevent="apply">
      <div class="input-box">
        <div class="form-input-group">
          <label for="firstName">First Name</label>
          <input type="text" id="firstName" v-model="volunteer.firstName"
            required autofocus />
        </div>
        <div class="form-input-group">
          <label for="lastName">Last Name</label>
          <input type="text" id="lastName" v-model="volunteer.lastName"
            required autofocus />
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
      volunteerService
        .postVolunteer(formData, options)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
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
.form-input-group {
  margin-bottom: 0.25rem;
}

label {
  margin-right: 0.25rem;
}

#login {
  color: rgb(43, 98, 134);
}

h1 {
  font-size: 2rem;
  text-align: center;
  margin-bottom: 0.25rem;
}

button {
  background-color: rgb(43, 98, 134);
  color: white;
  padding: 0.25rem;
  border-radius: 0.25rem;
  border: none;
  cursor: pointer;
  margin-bottom: 0.5rem;
  text-align: center;
}

button:hover {
  background-color: rgb(41, 93, 128);
}

button:active {
  background-color: rgb(41, 93, 128);
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
</style>
