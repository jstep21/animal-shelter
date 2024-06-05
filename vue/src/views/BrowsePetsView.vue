<template>
    <div class="home">
        <div class="home-page-heading">Home</div>
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

</style>