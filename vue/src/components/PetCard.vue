<template>
    <div id="pet-card">
        <span class="box">

            <div v-if="pet">
            {{  pet.name }}
            {{  pet.gender }}
            {{  pet.age }}
            </div>

        </span>
        
    </div>
</template>

<script>
export default {
    props: ['pet']
};

</script>

<style scope>
.box{
    display: inline-block;
    width: 200px;
    height: 200px;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 32px;

}

</style>