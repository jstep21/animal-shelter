<template>
  <div class="home">
    <h1>Home</h1>
    <p>You are authenticated if you see this.</p>
    <HomePage/> 
  </div>
</template>

<script>
import HomePage from '../components/HomePage.vue'

export default {
  components: {
    HomePage
  }
};
</script>
