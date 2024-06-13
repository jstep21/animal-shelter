<template>
    <div class="pet-details-card">
      <div id="pet-details-image" ref='petDetailsImage'>
        <v-carousel v-model='activeIndex' show-arrows='hover' >
          <v-carousel-item 
            v-for="(image, index) in imageData" :key="index" 
            :style="{ height: containerHeight + 'px' }"
            :src="image"
            class='pet-image'
          >
          </v-carousel-item>
        </v-carousel>
        <!-- <div v-else class='single-image'>
          <img 
            :src="imageData[0]"
            :style="{ height: containerHeight + 'px' }"
            alt="Pet Image" class="pet-image" @load='adjustContainerHeight' />
        </div> -->

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
      <div id="update-button">
      <button id="update" v-if="$store.state.token != ''">
            <router-link id="update-pet" v-bind:to="{name: 'update-pet'}"> Update Pet Info </router-link>
      </button>
    </div>
    </div>

</template>

<script>
import petService from "../services/PetService";
import ImageService from '../services/ImageService.js';

export default {
  props: ["pet"],
  data() {
    return {
      imageData: [],
      containerHeight: 0,
      activeIndex: 0
    }
  },

  created() {
    this.fetchPetImages(this.pet.petId)
  },

  mounted() {
    this.adjustContainerHeight();
    window.addEventListener('resize', this.adjustContainerHeight);
  },
  beforeUnmount() {
    window.removeEventListener('resize', this.adjustContainerHeight)
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
    adjustContainerHeight() {
      const firstImage = this.$refs.petDetailsImage.querySelector('.pet-image');
      if (firstImage) {
        const aspectRatio = firstImage.naturalWidth / firstImage.naturalHeight;
        this.containerHeight = this.$refs.petDetailsImage.offsetWidth / aspectRatio;
      }
    }
  }
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
  padding: .25rem;
  border-radius: 0.25rem;
  margin: .25rem;
  border: 1px solid white;
}

.v-carousel-item {
  position: relative;
  width: 100%;
  overflow: hidden;
}

.v-carousel-item img {
  width: 100%;
  height: auto;
  display: block;
  /* position: absolute;
  top: 0;
  left: 0; */
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
  height: auto;
  display: block;
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

.single-image {
  position: relative;
  width: 100%;
  overflow: hidden;
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

#update-button{
font-weight: bold;
}

</style>
