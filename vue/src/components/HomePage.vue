<template>
  <div class="body">
    <div class="splash-main-text">
      <h1 id="splash-title">Sheltered Furry Friends</h1>
      <span id="sub-title"> Volunteer and save a life! </span>
        <button id="splash-signup-button">
           <router-link class="signup" v-bind:to="{ name: 'apply'}"> Sign Up to be a Volunteer! </router-link> 
        </button>
    </div>

      <v-container class="hero-images">
        <v-responsive
          class='align-centerfill-height mx-auto'
          max-width='900'
          >
          <v-carousel show-arrows="hover" cycle="true" interval="10000">
            <v-carousel-item
              :src="dogImg"
              cover
              class='carousel-item clickable'
              @click="goToBrowsePets()"
            >
            </v-carousel-item>

            <v-carousel-item 
              v-for="(pet, index) in carouselPets" :key="index"
              :src="pet.petImageUrls[0]"
              @click="goToPetDetails(pet.petId)"
              cover
              class='carousel-item clickable'

            ></v-carousel-item>

        </v-carousel>
        </v-responsive>
      </v-container>

    <div class="splash-secondary-text">
      <h2 id="secondary-title">How To Help</h2>
      <span id="secondary-sub-title">
        Get involved with Sheltered Furry Friends</span
      >
    </div>

    <br>
    <br>

    <div class="links-box">

      <div class="links-card">
        <div><strong>Find your newest family member!</strong></div>
        <button id="search-adoptees-button" @click="goToBrowsePets">
            Search available adoptees
        </button>
      </div>

      <div class="links-card">
        <div><strong>Volunteer at a shelter!</strong></div>
        <button id="volunteer-signup-button">
            <router-link v-bind:to="{ name: 'apply'}"> Sign up to be a volunteer </router-link>
        </button>
      </div>

      <div class="links-card">
        <div><strong>Tell your friends about us!</strong></div>
        <div><button id="invite-friend-button">Invite a friend</button></div>
      </div>
    </div>

  </div>

</template>

<script>
import img from '@/assets/Shelter Dog 2.jpg'
import petService from '../services/PetService.js'

export default {
  created() {
    this.fetchCarouselPets();
    console.log(this.carouselPets);
  },
  data() {
    return {
      dogImg: img,
      carouselPets: [],
    }
  },
  methods: {
    goToBrowsePets() {
        this.$router.push({ name: 'browse-pets'});
    },

    goToPetDetails(petId) {
      this.$router.push({ name: "pet-details", params: { petId } });
    },

    fetchCarouselPets() {
      petService
        .getAllPets()
        .then((response) => {
          const firstPet = response.data[0];
          const secondPet = response.data[8];
          const thirdPet = response.data[11];
          
          this.carouselPets.push(firstPet);
          this.carouselPets.push(secondPet);
          this.carouselPets.push(thirdPet);
          // this.carouselPets = response.data
          //   .slice(0, 2);
        })
        .catch((error) => {
          console.error("Error fetching pet data: ", error);
        });
    },

  }
}

</script>

<style scoped>

.splash-main-text {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 30px; 
}

#splash-signup-button {
  border-radius: 25px;
  padding: 10px;
  background-color: black;
  color: white;
  margin-bottom: 50px;
  margin-top: 10px;
}

.signup {
  color: white;
  text-decoration: none;
}
.splash-secondary-text {
    margin-left: 10px;
}

#sub-title {
  font-size: large;
}

#secondary-title {
  font-size: xx-large;
  margin-top: 50px;
}

#secondary-sub-title {
  color: #626e72;
  font-size: large;
}

/* #invite-friend-button {
   margin-left: 75px; 
} */

.splash-hero-image {
  display: flex;
  align-content: center;
  justify-content: center;
}

img {
  width: 50%;
  height: 40%;
}

.links-box {
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100vw;
  font-size: x-large;
  margin-bottom: 50px;
}
.links-card {
  display:flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  /* border: solid lightgray 3px;
  padding: 5px; */
  padding: 10px;
  border: 1px solid #767e8b;
  box-shadow:  -1px 1px #767e8b,
         -2px 2px #767e8b,
         -3px 3px #767e8b,
         -4px 4px #767e8b,
         -5px 5px #767e8b;
 }
.links-card > *:not(:last-child) {
    margin-bottom: 20px;
}
.links-box button {
  border-radius: 15px;
  padding: 10px;
  background-color: black;
  color: white;
  font-size: large;
}
.clickable {
  cursor: pointer;
}
a, a:visited {
  text-decoration: none;
  color:inherit;
}

@media (max-width: 950px) {
  .links-box {
    display: grid;
    gap: 2rem;
    grid-template-columns: 1fr 1fr;
    width: 100vw;
    justify-items: flex-start;
    font-size:x-large;
    margin: 0px 0px 50px 50px;
  }
}
@media (max-width: 800px) {
  .links-card {
    align-items: start;
 }
  .links-box {
    display: grid;
    gap: 2rem;
    grid-template-columns: 1fr;
    width: 100vw;
    justify-items: flex-start;
    font-size:x-large;
    margin: 0px 0px 50px 50px;
  }
}

</style>
