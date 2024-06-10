<template>
    <div class="pet-details-card">
      <div id="pet-details-image">
        <img :src="pet.petImageUrls[0]" alt="Pet Image" class="pet-image" />
      </div>
      <div id="pet-details">
        <div class="pet-details-info-box" v-if="pet">
          <ul>
            <li>Name: {{ pet.name }}</li>
            <li>Gender: {{ pet.gender }}</li>
            <li>Age: {{ pet.age }} years</li>
            <li>Species: {{ pet.species }}</li>
            <li>Breed: {{ pet.breed }}</li>
            <li>Weight: {{ pet.weight }} pounds</li>
            <li>
              {{ pet.gender == 'Female' ? 'Spayed' : 'Neutered' }} :
              {{ pet.spayedNeutered ? "Yes" : "No" }}
            </li>
            <li>Descriptions: {{ pet.petDescriptions.join(", ") }}</li>
          </ul>
        </div>
      </div>
    </div>
</template>

<script>
import petService from "../services/PetService";

export default {
  props: ["pet"],
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');

.pet-details-card {
  display: flex;
  flex-direction: column;
  background-color: rgb(18, 84, 128);
  padding: 1rem;
  border-radius: .5rem;
  color: white;
  font-family: 'Lato', sans-serif;
  font-weight: 300;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.9);
  width: 40%;
}

#pet-details-image {
  position: relative;
  width: auto;
  height: auto;
  padding: .25rem;
  border-radius: 0.25rem;
  margin: .25rem;
  border: 1px solid white;
}

.pet-details-info-box {
  position: relative;
  width: auto;
  height: auto;
  font-size: larger;
  font-weight: 500;
  padding: .25rem;
  border-radius: 0.25rem;
  margin: .25rem;
  border: 1px solid white;
  color: white;
}

.pet-details-info-box ul {
  list-style-type: none;
  padding: 10px;
  margin: 10px;
  background-color: white;
}

.pet-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.info-box {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 30%;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: background-color 0.3s ease, color 0.3s ease;
}

.details:hover .info-box {
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
}

.info-box ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
  text-align: center;
}

.info-box li {
  font-size: 14px;
}

.pet-name {
  margin-bottom: 10px;
  color: rgb(43, 98, 134);
  font-size: 1.5rem;
}

ul {
  padding: 0;
  margin: 0;
  list-style-type: none;
}

li {
  margin-bottom: 10px;
  color: rgb(43, 98, 134);
  font-family: 'Lato', sans-serif;
  font-weight: 700;
}

</style>
