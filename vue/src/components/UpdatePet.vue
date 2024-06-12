<template>
    <div>
      <!-- <h1>Update Pet Information:</h1>
      
      <br><br>
      <v-sheet class="mx-auto" width="300">
        <v-form @submit.prevent='addPet'>
          <v-text-field
            v-model="newPet.name"
            :rules="rules"
            label="Name"
          ></v-text-field>
  
          <v-text-field
            v-model="newPet.species"
            :rules="rules"
            label="Species"
          ></v-text-field>
  
          <v-text-field
            v-model="newPet.breed"
            :rules="rules"
            label="Breed"
          ></v-text-field>
  
          <v-text-field
            v-model="newPet.weight"
            :rules="rules"
            label="Weight"
          ></v-text-field>
  
          <v-text-field
            v-model="newPet.gender"
            :rules="rules"
            label="Gender"
          ></v-text-field>
  
          <v-text-field
            v-model="newPet.age"
            :rules="rules"
            label="Age"
          ></v-text-field>
  
          <v-checkbox 
            label="Spayed/Neutered?" 
            v-model='newPet.spayedNeutered'>
          </v-checkbox>
  
          <v-combobox
            label="How would you describe this furry friend?"
            :items="petDescriptions"
            v-model='newPetDescriptions.descriptions'
            multiple
          ></v-combobox>
  
          <v-file-input 
            label="Upload pictures"
            id='file' 
            ref='fileInput'
            >
          </v-file-input>
  
          <v-btn color="rgb(43, 98, 134)" class="mt-2" type="submit" block>Submit</v-btn>
        </v-form>
      </v-sheet>
   -->
    </div>
  </template>

<script>
</script>

<style>
</style>