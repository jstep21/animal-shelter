<template>
    <div class="volunteer">
        <h1> Volunteer List:</h1>
        <div class="volunteer-view">
            <VolunteerCard class="volunteers" :volunteer="volunteer" />
        </div>

    </div>
</template>

<script>
import VolunteerCard from '../components/VolunteerCard.vue';

export default {
    components: {
        VolunteerCard   
    },
    created() {
    this.$store.commit("SET_BG", true);
  }
}

</script>

<style scoped>
h1 {
    margin-top: 50px;
    margin-bottom: 50px;
}

</style>