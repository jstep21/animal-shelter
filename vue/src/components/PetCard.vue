<template>
  <div id="pet-card" @click="$emit('click')">
      <div class="card" v-if="pet">
        <img :src="imageData[0]" alt="Pet image" class="pet-image">
        <div class="info-box">
          <ul>
            <li>{{ pet.name }}</li>
            <span class="pet-details">{{ pet.gender }}</span>
            <span class="pet-details">{{ pet.age }} yrs</span>
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
  watch: {
    pet: {
      immediate: true,
      handler(newPet) {
        if (newPet && newPet.petId) {
          this.fetchPetImages(newPet.petId)
        }
      }
    }
  },


  methods: {
    fetchPetImages(petId) {
      const headers = {
        headers: {
          'Content-Type': 'image/jpg;base64',
          'Accept' : 'application/json'
        }
      }
      console.log(petId);

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
  font-family:'Lato', sans-serif;
  font-weight: 600;
  font-size: 16px;
  font-style: normal;
}
.pet-details {
  
  margin-right: 1rem;
  font-family:'Lato', sans-serif;
  font-weight: 600;
  font-size: 16px;
  font-style: normal;
} 
</style>
