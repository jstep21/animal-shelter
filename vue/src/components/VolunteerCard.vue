<template>
    <v-container class="d-flex align-center justify-center fill-height">
        <v-list>
            <v-list-item-group >
                <v-list-item v-for="(volunteer, index) in volunteers" :key="index">
                    <v-list-item-content>
                        <v-list-item-title>{{ volunteer.firstName }}{{ volunteer.lastName }}</v-list-item-title>
                        <v-list-item-subtitle>Email: {{ volunteer.email }}</v-list-item-subtitle>
                        <v-list-item-subtitle>Phone: {{ volunteer.phoneNumber }}</v-list-item-subtitle>
                        <v-list-item-subtitle>Zip Code: {{ volunteer.zipCode }}</v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </v-container>
</template>

<script> 
import VolunteerService from '../services/VolunteerService';

export default {

  data() {
        return {
            volunteers: []
        };
    },
    methods: {
        showAllVolunteers() {
            VolunteerService.getAllVolunteers().then( (response) => {
                this.volunteers = response.data;
                console.log(this.volunteers)
            })
            .catch((error) => {
                console.error("Error retrieving volunteer data", error)
            })
        }
    },
    created() {
        this.showAllVolunteers();
    }
};
</script>


<style> 

</style>