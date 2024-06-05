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
import PetCard from './PetCard.vue';

export default {

    components: {
        PetCard
    },
    
    data() {
        return {
            // pets: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14],
            pets: [
                    {
                        name: 1
                    },
                    {
                        name: 2
                    },
                    {
                        name: 3
                    },
                    {
                        name: 4
                    },
                    {
                        name: 5
                    },
                    {
                        name: 6
                    },
                    {
                        name: 7
                    },
                    {
                        name: 8
                    },
                    {
                        name: 9
                    },
                    {
                        name: 10
                    },
                    {
                        name: 11
                    },
                    {
                        name: 12
                    },
                    {
                        name: 13
                    },
                    {
                        name: 14
                    },
            ]
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
        }
    }
}
</script>

<style>


</style>