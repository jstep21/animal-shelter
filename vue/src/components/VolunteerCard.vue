<template> 
    <div class="volunteer-card">
        <div id="volunteer-info">
            <ul>
                <li> Name: {{volunteer.firstName}} {{ volunteer.lastName }}</li>
                <li> Email: {{ volunteer.email }}</li>
                <li> Phone Number: {{ volunteer.phoneNumber }}</li>
                <li> Zip code: {{ volunteer.zipCode }}</li>
            </ul>
        </div>
    </div>
</template>


<script> 
import VolunteerService from '../services/VolunteerService';

export default {

  data() {
        return {
            volunteer: []
        };
    },
    methods: {
        showAllVolunteers() {
            VolunteerService.getAllVolunteers().then( (response) => {
                this.volunteer.push(response.data);
                console.log(this.volunteer)
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