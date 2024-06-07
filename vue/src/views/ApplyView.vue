<template>
  <div id="login" class="login-container" :style="{ backgroundImage: `url(${backgroundImage})` }">
    <form v-on:submit.prevent="login">
      <h1>Apply View -- Edit me!!</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="input-box">
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      </div>
      <button type="submit">Sign in</button>
      <p class="center-text">
        <router-link class="custom-link" v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link>
      </p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import homePageDogPic from "@/assets/Shelter Dog 2.jpg";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false,
      backgroundImage: homePageDogPic
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: .25rem;
}

label {
  margin-right: .25rem;
}

#login {
  color: rgb(43, 98, 134);
}

h1 {
  font-size: 2rem;
  text-align: center;
  margin-bottom: .25rem;
}

button {
  background-color: rgb(43, 98, 134);
  color: white;
  padding: .25rem;
  border-radius: 0.25rem;
  border: none;
  cursor: pointer;
  margin-bottom: .5rem;
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
  padding: .25rem;
  border-radius: .25rem;
  margin: .25rem;
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
  background-image: url('@/assets/Shelter Dog 2.jpg');
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