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
.pet-details-card {
  display: flex;
  flex-direction: column;

}
#pet-details-image {
  position: relative;
  width: 500px;
  height: 500px;
  padding: 10px;
  border: solid #a1dd70 2px;
  margin: 5px;
}
.pet-details-info-box {
  position: relative;
  width: 500px;
  height: auto;
  font-size: larger;
  font-weight: 500;
  padding: 10px;
  border: solid #a1dd70 2px;
  margin: 5px;
}
.pet-details-info-box ul {
list-style-type: none;
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
  background-color: rgba(0, 0, 0, 0.2);
  color: #dddddd;
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
</style>
