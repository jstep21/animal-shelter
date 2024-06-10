<template>
  <div class="home">    
    <HomePage/> 
  </div>
</template>

<script>
import { createNamespacedHelpers } from 'vuex';
import HomePage from '../components/HomePage.vue'

export default {
  components: {
    HomePage
  },

  created() {
    this.$store.commit("SET_BG", false);
  }
};
</script>

<style scoped>


</style>
