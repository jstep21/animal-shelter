<template>
  <div
    id="approve-view"
    class="approve-container" 
    :style="{ backgroundImage: `url(${backgroundImage})` }"
  >
    <div id="approve-header">
      <h1>Volunteers Pending Review</h1>
      <h2>Approve or decline pending volunteer applications using the buttons below.</h2>
      <Approve />
    </div>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";
import homePageDogPic from "@/assets/Shelter Dog 2.jpg";
import Approve from "../components/Approve.vue";

export default {
  components: {
    Approve,
  },
  data() {
    return {
      backgroundImage: homePageDogPic,
    };
  },
  methods: {},
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

.approve-container {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  height: 100%;
  background-size: cover;
  background-position: center;
}
.approve-container::before {
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
#approve-header {
  display: flex;
  flex-direction: column;
}
#approve-header > h1 {
  margin: 100px auto;
}
#approve-header > h2 {
  font-style: italic;
  margin-bottom: 100px;
  color: #444444;
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
