<template>
    <div class="home">
        <div class="home-page-heading"> </div>
        <div id="browse" class="browse-container" :style="{ backgroundImage: `url(${backgroundImage})` }">
            <h1 id="browse-title">Available adoptees</h1>
            <div class="table-view">
                <PetTable class="pets" />
            </div>
        </div>
    </div>
</template>

<script>

import PetTable from '../components/PetTable.vue';
import homePageDogPic from "@/assets/Shelter Dog 2.jpg";

export default {
    components: {
        PetTable,
    },
    data() {
        return {
            backgroundImage: homePageDogPic,
        };
    },
};

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@100&display=swap');

.home {
    height: 100%;
}

.browse-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100%;
    background-size: cover;
    background-position: center;
    color: rgb(43, 98, 134);
    font-family: 'Lato', sans-serif;
    font-weight: 100;
    
}

#browse-title {
    font-size: 3rem;
    text-align: center;
    margin-bottom: 3rem;
    margin-top: 3rem;
    color: rgb(43, 98, 134);
}

.table-view {
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 10px;
}

.pet-table {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 1rem;
    font-family: 'Lato', sans-serif;
    font-weight: 100;
}

.pet {
    border: 2px solid rgb(43, 98, 134);
    padding: 1rem;
    border-radius: 1rem;
    text-align: center;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.pet-image {
    width: 100%;
    max-width: 200px;
    border: 5px solid transparent;
    border-radius: 1rem;
}

.browse-container::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-image: url('@/assets/Shelter Dog 2.jpg');
    /* background-size: cover; */
    background-size: 100% 100%;
    background-position: center;
    opacity: 0.1;
    z-index: -1;
}
</style>