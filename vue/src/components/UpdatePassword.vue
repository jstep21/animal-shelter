<template>
  <div class="update-password-container">
      <h1>Update Password</h1>
      <form @submit.prevent="updatePassword">
        <div class="form-group">
          <label for="new-password">New Password</label>
          <input
            type="password"
            id="new-password"
            v-model="newPassword"
            required      
          />
        </div>
        <div class="form-group">
          <label for="confirm-password">Confirm Password</label>
          <input
            type="password"
            id="confirm-password"
            v-model="confirmPassword"
            required
          />
        </div>
        <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
        <button type="submit">Update Password</button>
      </form>
    </div>
</template>

<script>
import VolunteerService from '../services/VolunteerService.js';

export default {
  data() {
    return {
      newPassword: '',
      confirmPassword: '',
      errorMessage: ''
    };
  },
  methods: {
    updatePassword() {
      if (this.newPassword !== this.confirmPassword) {
        this.errorMessage = 'Passwords do not match';
        return;
      }
      try {
        VolunteerService.updatePassword(this.newPassword).then(() => {
          this.$router.push({ name: 'profile' });
        });
      } catch (error) {
        this.errorMessage = error.response.data.message;
      }
    },
  },
};
</script>

<style scoped>
.update-password-container {
  position: relative;
  width: 300px;
  padding: 20px;
  border: solid rgb(43, 98, 134) 2px;
  margin: 200px auto;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  background-color: #f9f9f9;
}

h1 {
  text-align: center;
  color: rgb(43, 98, 134);
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
  color: rgb(43, 98, 134);
}

input {
  width: 100%;
  padding: 8px;
  border: solid rgb(43, 98, 134) 1px;
  border-radius: 4px;
  box-sizing: border-box;
}

button {
  width: 100%;
  padding: 10px;
  background-color: rgb(43, 98, 134);
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button:hover {
  background-color: rgb(34, 78, 108);
}

.error-message {
  color: red;
  margin-bottom: 15px;
  text-align: center;
}
</style>