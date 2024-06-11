<template>
  <div>
    <h1>Add a New Adoptable Pet!</h1>
    
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
          label-color="rgb(43, 98, 134)"
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

  </div>
</template>

<script>
import petService from '../services/PetService';
import imageService from '../services/ImageService';
//          if using this add multiple to v-file-input
//          v-on:change='addFile'
//           v-on:change="uploadFile" 
export default {
  data() {
    return {
      file: [],
      imageData: null,
      error: null,
      newPet: {
        name: '',
        species: '',
        breed: '',
        weight: '',
        gender: '',
        age: '',
        spayedNeutered: false,
        petImageUrls: []
      },
      petDescriptions: [],
      newPetDescriptions: {
        petId: '',
        descriptions: []
      }

    }
  },
  created() {
    this.getAllDescriptions();
  },
  methods: {

    async addPet() {
      const headers = {
          'Content-Type': 'application/json',
          'Accept' : 'application/json'
        }
      try{
        const response = await petService.addPet(this.newPet, headers);
        const newId = response.data.petId
        await this.addPetDescriptions(newId);
        await this.uploadFile(newId);
      } catch(error) {
          console.error('Error: ', error);
      }
    },

    // addFile() {
    //   this.file.push(this.$refs.fileInput.files);
    //   console.log(this.file);
    // },

    async uploadFile(petId) {
      
      this.file = this.$refs.fileInput.files[0];

      let formData = new FormData();
      formData.append('file', this.file);

      const options = {
        headers: {
          'Content-Type': 'multipart/form-data',
          'Accept' : 'application/json'
        }
      }
      
      try {
        const response = await imageService.postImage(formData, petId, options);
        if (response.status >= 200) {
          this.$router.push({name: 'home'});
        }
      }
      catch (error) {
        console.error('Error: ', error)
      }

    },

    async addPetDescriptions(petId) {
      const headers = {
        'Content-Type': 'application/json',
        'Accept' : 'application/json'
      }
      this.newPetDescriptions.petId = petId;
      try{
        await petService.addPetDescriptions(this.newPetDescriptions, headers);
      } catch(error) {
          console.error('Error: ', error);
      }
    },

    getAllDescriptions() {
      petService.getAllDescriptions().then(
        (response) => {
          this.petDescriptions = response.data;
        }
      )
      .catch((error) => {
          console.error("Error fetching pet data: ", error);
      });
    }
  }
}
</script>

<style>
h1 {
  display: flex;
  justify-content: center;
  color:  rgb(43, 98, 134);
}

.v-text-field .v-label {
  color: rgb(43, 98, 134);
}

.v-checkbox .v-label {
  color: rgb(43, 98, 134);
}

.v-file-input .v-label {
  color: rgb(43, 98, 134);
}

</style>