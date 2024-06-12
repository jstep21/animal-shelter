<template>
  <div>
    <div class="scrollable-container">
      <table class="pet-card-grid">
        <tr v-for="(row, rowIndex) in rows" :key="rowIndex">
          <td v-for="(curPet, cellIndex) in 4" :key="cellIndex">
            <PetCard
              :pet="petCell(rowIndex, cellIndex)"
              @click="goToPetDetails(petCell(rowIndex, cellIndex).petId)"
            />
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import PetCard from "./PetCard.vue";
import petService from '../services/PetService.js';
import ImageService from '../services/ImageService.js';

export default {
  components: {
    PetCard,
  },

  data() {
    return {
      pets: [],
      // imageData: [],
    };
  },
  computed: {
    rows() {
      let rowCount = parseInt(this.pets.length / 4);
      const leftOver = this.pets.length % 4;
      if (leftOver > 0) {
        rowCount++;
      }
      return rowCount;
    },
  },
  methods: {
    petCell(row, cell) {
      const index = row * 4 + cell;
      return index < this.pets.length ? this.pets[index] : undefined;
    },
    fetchPets() {
      petService
        .getAllPets()
        .then((response) => {
          this.pets = response.data

            // limits our max pets to display
            .slice(0,17);
          console.log(this.pets);
        })
        .catch((error) => {
          console.error("Error fetching pet data: ", error);
        });
    },

    goToPetDetails(petId) {
      this.$router.push({ name: "pet-details", params: { petId } });
    },
  },
  created() {
    this.fetchPets();
  },
};
</script>

<style>
.scrollable-container {
  max-height: 80vh;
  overflow-y: auto;
  margin: 0 auto;
}
.pet-card-grid {
  width: 100%;
  border-collapse: collapse;
}
.pet-card-grid td {
  padding: 0px;
}
</style>
