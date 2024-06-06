<template>
  <!-- <v-icon icon="mdi-home" /> -->


  <v-app>
    <v-app-bar>
      <template v-slot:prepend>
        <v-app-bar-nav-icon></v-app-bar-nav-icon>
      </template>
      <v-app-bar-title>Pet Shelter</v-app-bar-title>
    </v-app-bar>



  <v-container class='fill-height'>
    <v-responsive
      class='align-centerfill-height mx-auto'
      max-width='900'
      >
        <v-carousel show-arrows="hover">
        <v-carousel-item
          :src="dogImg"
          cover
          class='carousel-item'
        >
        </v-carousel-item>

        <v-carousel-item
          src="https://cdn.vuetifyjs.com/images/cards/hotel.jpg"
          cover
          class='carousel-item'

        ></v-carousel-item>

        <v-carousel-item
          src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
          cover
          class='carousel-item'

        ></v-carousel-item>
      </v-carousel>
      </v-responsive>
    </v-container>

  </v-app>

    <input type='file' id='file' ref='fileInput'/>
</template>

<script>
import img from '@/assets/Shelter Dog 2.jpg'
import ImageService from '../services/ImageService.js'

export default {
  data() {
    return {
      dogImg: img,
      file: {}
    }
  },
  methods: {
    uploadFile() {
      this.file = this.$refs.fileInput.files[0];

      let formData = new FormData();
      formData.append('filename', this.file);

      const options = {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }
      
      ImageService.postImage(formData, options).then(
        (response) => {
          console.log('Response: ', response.data)
        }
      ).catch(error => {
          console.error('Error: ', error);
      });
    }
  }
}
</script>

<style>


</style>