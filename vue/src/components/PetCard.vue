<template>
  <div id="pet-card" @click="$emit('click')">
      <div class="card" v-if="pet">
        <img :src="imageData[0]" alt="Pet image" class="pet-image">
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
import ImageService from '../services/ImageService.js';

export default {
  props: ['pet'],
  data() {
    return {
      imageData: []
    }
  },

  created() {
    this.fetchPetImages(this.pet.petId)
  },

  methods: {
    fetchPetImages(petId) {
      const headers = {
        headers: {
          'Content-Type': 'image/jpg;base64',
          'Accept' : 'application/json'
        }
      }

      ImageService.retrieveImages(petId, headers).then(
        (response) => {
          this.imageData = response.data;
        }
      )
      .catch (error => {
        console.error("Error fetching pet data: ", error);
      })
    },
  }
};
</script>

<style scoped>
#pet-card {
  position: relative;
  width: 200px;
  height: 200px;
  padding: 10px;
  border:solid rgb(43, 98, 134) 2px;
  margin: 10px;
  
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
    cursor: pointer;
}
.info-box {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 30%;
  background-color: rgba(0, 0, 0, 0.5); 
  color: #DDDDDD;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: background-color 0.3s ease, color 0.3s ease; 
}
.card:hover .info-box {
    background-color: rgba(0, 0, 0, 0.7);
    color: white;
}
.info-box ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
  text-align: center;
}
.info-box li {
  font-size: 12px;
}

</style>
