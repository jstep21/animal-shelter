<template>
  <div class="home">
    <div class="pet-details-heading"></div>

    <!-- TODO: consider changing "Animal" to species or breed -->
    <h1 id="pet-details-title">Adopt this Lovely Animal Today!</h1>

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
        pet: null
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
  margin-top: 1em;
  font-family: "Impact, Charcoal, sans-serif";
}
</style>
