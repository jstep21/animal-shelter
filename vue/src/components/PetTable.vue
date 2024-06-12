<template>
  <div>
    <div class="scrollable-container">
      <div>
        <v-text-field v-model="search" label="Search" clearable @input="applyFilter"></v-text-field>
      </div>
      <table class="pet-card-grid">
        <tr v-for="(row, rowIndex) in rows" :key="rowIndex">
          <td v-for="(curPet, cellIndex) in row" :key="cellIndex">
            <PetCard
              v-if="curPet"
              :pet="curPet"
              @click="goToPetDetails(curPet.petId)"
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
      search: '',
      // imageData: [],
    };
  },
  computed: {
    filteredPets() {
      if (this.search === '') {
        return this.pets;
      }
      console.log(this.search);
      const searchWords = this.search.toLowerCase();
      return this.pets.filter(
        pet => Object.values(pet).some(
          value => String(value).toLowerCase().includes(searchWords)
        )
      );
    },
    rows() {

      // let rowCount = parseInt(this.pets.length / 4);
      // const leftOver = this.pets.length % 4;
      // if (leftOver > 0) {
      //   rowCount++;
      // }
      // return rowCount;

      const rows = [];
      for (let i=0; i<this.filteredPets.length; i+=4) {
        rows.push(this.filteredPets.slice(i, i + 4));
        console.log(rows);
      }
      return rows;
    },
  },
  methods: {

    // Second v-for was looping through 4 so row was always expected to be 4
    // v-bind to child component (PetCard) was originally this petCell method
    // but was returning undefined if the row was not filled with 4 pets

    // petCell(row, cell) {
    //   const index = row * 4 + cell;
    //   return index < this.pets.length ? this.pets[index] : undefined;
    // },

    fetchPets() {
      petService
        .getAllPets()
        .then((response) => {
          this.pets = response.data;
          console.log(this.pets);
        })
        .catch((error) => {
          console.error("Error fetching pet data: ", error);
        });
    },

    goToPetDetails(petId) {
      this.$router.push({ name: "pet-details", params: { petId } });
    },
    applyFilter() {

    }
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
