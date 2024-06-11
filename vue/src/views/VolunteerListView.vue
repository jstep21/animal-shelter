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
import VolunteerService from '../services/VolunteerService';

export default {
    components: {
        VolunteerCard   
    },

    // data() {
    //     return {
    //         volunteer: []
    //     };
    // },
    // methods: {
    //     showAllVolunteers() {
    //         VolunteerService.getAllVolunteers.then( (response) => {
    //             this.volunteer = response.data;
    //         })
    //         .catch((error) => {
    //             console.error("Error retrieving volunteer data", error)
    //         })
    //     }
    // },
    // created() {
    //     this.showAllVolunteers();
    // }
}

</script>

<style>
</style>