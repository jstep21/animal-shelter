<template>
    <div class="home">
        <div class="home-page-heading">Home</div>
        <div>
            <PetTable  class="pets"/>
        </div>
    </div>
</template>

<script>

import PetTable from '../components/PetTable.vue';

export default {
    components: {
        PetTable
    }
}

</script>

<style scoped>
/* .home {
  margin-top: 50px;
  padding: 20px;
}
.pets {
    
} */
</style>