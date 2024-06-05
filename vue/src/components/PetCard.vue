<template>
  <div id="pet-card">
      <div class="card" v-if="pet">
        <img :src="pet.petImageUrls[0]" alt="Queso" class="pet-image">
        <div class="info-box">
          <ul>
            <li>Name: {{ pet.name }}</li>
            <li>Gender: {{ pet.gender }}</li>
            <li>Age: {{ pet.age }}</li>
          </ul>
        </div>
      </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  props: ["pet"],
};
</script>

<style scoped>
#pet-card {
  position: relative;
  width: 200px;
  height: 200px;
}
.card {
  position: relative;
  width: 100%;
  height: 100%;
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
  color: #DDDDDD;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: background-color 0.3s ease, color 0.3s ease; 
}
.card:hover .info-box {
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
