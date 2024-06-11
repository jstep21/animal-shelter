<template>
  <div>
    <add-pet v-bind:newPet="newPet"></add-pet>
  </div>
</template>

<script>
import AddPet from '../components/AddPet.vue';

export default {
  components: {
    AddPet
  },


}
</script>

<style>

</style>