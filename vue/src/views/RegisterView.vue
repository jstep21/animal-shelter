<template>
  <div id="register" class="login-container" :style="{ backgroundImage: `url(${backgroundImage})` }">
    <form v-on:submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
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
        <div class="form-input-group">
          <label for="confirmPassword">Confirm Password</label>
          <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
        </div>
      </div>
      <button type="submit">Create Account</button>
      <p class="center-text">
        <router-link class="custom-link" v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link>
      </p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';
import homePageDogPic from "@/assets/Shelter Dog 2.jpg";

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
      backgroundImage: homePageDogPic,
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: .25rem;
}

label {
  margin-right: .25rem;
}
#register {
  color: rgb(43, 98, 134);
}
h1 {
  font-size: 2rem;
  text-align: center;
  margin-bottom: .5rem;
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
  background-color: rgb(43, 98, 134);
}
button:active {
  background-color: rgb(43, 98, 134);
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
  border-radius: 0.25rem;
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
  content: '';
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
  color: rgb(43, 98, 134);
  text-decoration: underline;
}
.input-box {
  display: flex;
  flex-direction: column;
  align-items: center;
}
label {
  margin-right: .25rem;
}
.form-input-group {
  margin-bottom: 1rem;
}
</style>
