<template>
  <div id="apply-view" class="apply-container" :style="{ backgroundImage: `url(${backgroundImage})` }">
    <div>
      <Apply />
    </div>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";
import homePageDogPic from "@/assets/Shelter Dog 2.jpg";
import Apply from '../components/Apply.vue';

export default {
  components: {
    Apply
  },
  data() {
    return {
      backgroundImage: homePageDogPic
    };
  },
  methods: {
  },
  created() {
    this.$store.commit("SET_BG", true);
  }
};
</script>

<style scoped>

#apply-view {
  margin-top: 50px;
}
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

.apply-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-size: cover;
  background-position: center;
}

/* .apply-container::before {
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
} */

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