<template>
  <div class="home">
    <div class="pet-details-heading"></div>

    <!-- TODO: consider changing "Animal" to species or breed / changed to 
    Furry Friend by MK-->
    <h1 id="pet-details-title">Adopt this Furry Friend Today!</h1>

    <div class="table-view" v-if="pet">
      <PetDetails class="pets" :pet="pet" />
    </div>
  </div>
</template>

<script>
import PetDetails from "../components/PetDetails.vue";
import petService from "../services/PetService";

export default {
  components: {
    PetDetails
  },
  data() {
    return {
        pet: null,
        imageData: []
    };
  },
  methods: {
    fetchPet(petId) {
      petService.getPet(petId)
        .then((response) => {
          this.pet = response.data;
        })
        .catch((error) => {
          console.error("Error fetching pet data: ", error);
        });
    },
  },
  created() {
    const petId = this.$route.params.petId;
    this.fetchPet(petId);
  }
};
</script>

<style scoped>
.table-view {
  display: flex;
  justify-content: center;
  align-items: center;
}
#pet-details-title {
  text-align: center;
  font-size: 3em;
  margin-top: 10px;
  font-family: 'Lato', sans-serif;
}
h1 {
  font-size: 2rem;
  text-align: center;
  margin-bottom: .5rem;
  color: rgb(43, 98, 134);
}
.home {
  background-cover: cover;
  background-color: aliceblue
}
</style>
