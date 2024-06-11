<template>
    <div class="volunteer">

        <div class="volunteer-view" v-if="volunteer">
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
    data() {
        return {
            volunteer: null
        };
    }
}

</script>

<style>
</style>