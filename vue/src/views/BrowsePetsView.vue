<template>
    <div class="home">
        <div class="home-page-heading">Home</div>
        <h1 id="browse-title">Available adoptees</h1>
        <div class="table-view">
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

.table-view {
    display: flex;
    justify-content: center;
    align-items: center;
}
#browse-title {
    text-align: center;
    font-size: 4em;
    margin-top: 1em;
    font-family: 'Impact, Charcoal, sans-serif';
}

</style>