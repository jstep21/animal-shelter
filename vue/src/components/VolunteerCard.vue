<template> 
    <div class="volunteer-card">
        <div id="volunteer-info" v-if="volunteer">
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

export default {
  props: ["volunteer"],
};
</script>


<style> 

</style>