<template>
    <div>
        <table class="pet-card-grid">
            <tr v-for="(row, rowIndex) in rows" :key="rowIndex">
                <td v-for="(curPet, cellIndex) in 4" :key="cellIndex">
                    <PetCard :pet="petCell(rowIndex, cellIndex)"/>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
import axios from 'axios';
import PetCard from './PetCard.vue';
import petService from '../services/PetService';


export default {

    components: {
        PetCard
    },
    
    data() {
        return {
             pets: [] // Start with an empty array
            //         {
            //             name: 1
            //         },
            //         {
            //             name: 2
            //         },
            //         {
            //             name: 3
            //         },
            //         {
            //             name: 4
            //         },
            //         {
            //             name: 5
            //         },
            //         {
            //             name: 6
            //         },
            //         {
            //             name: 7
            //         },
            //         {
            //             name: 8
            //         },
            //         {
            //             name: 9
            //         },
            //         {
            //             name: 10
            //         },
            //         {
            //             name: 11
            //         },
            //         {
            //             name: 12
            //         },
            //         {
            //             name: 13
            //         },
            //         {
            //             name: 14
            //         },
            
        }
    },
    computed: {
        rows() {
            let rowCount = parseInt(this.pets.length / 4);
            const leftOver = this.pets.length % 4;
            if (leftOver > 0) {
                rowCount++;
            }
            return rowCount;
        }
    },
    methods: {
        petCell(row, cell) {
            const index = (row * 4) + cell;
            return index < this.pets.length ? this.pets[index] : undefined;        
        },
        fetchPet(petId) {
            return petService.getPet(petId);
        },
        async fetchPets() {
            try {
                /*** add pets here by id ***/
                const petIds = [1001, 1002, 1003, 1004, 1005, 1006,
                                1007, 1008, 1009, 1010, 1011, 1012];
                const petPromises = petIds.map(id => this.fetchPet(id));
                const petResponses = await Promise.all(petPromises);
                this.pets = petResponses.map(response => response.data);
            } catch (error) {
                console.error('Error fetching pet data: ', error);
            }
        }
    },
    mounted() {
        this.fetchPets();
    }
}
</script>

<style>


</style>