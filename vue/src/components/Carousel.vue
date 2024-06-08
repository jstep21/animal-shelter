<template>
  <v-icon icon="mdi-home" />


  <v-app>
    <v-app-bar app color='rgba(41, 93, 128, 1)' class='px-10' dark>
        <v-app-bar-nav-icon @click.stop='menu = !menu'> 
        </v-app-bar-nav-icon>
        <v-app-bar-title>Pet Shelter</v-app-bar-title>

        <v-spacer></v-spacer>
        <v-btn text>Sign In</v-btn>

        <v-menu
          v-model='menu' 
          :close-on-content-click='false' 
          offset-y="400"
          
        >
          <template v-slot:activator="{ on, attr }">
            <v-btn
              color="primary"
              v-bind="attr"
              v-on="on"
            >
            </v-btn>
          </template>

          <v-list>
            <v-list-item
              v-for="(item, index) in menuItems"
              :key="index" 
              link 
              @click='navigate(item)'
            >
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
    </v-app-bar>



    <v-container class='fill-height'>
      <v-responsive
        class='mx-auto'
        max-width='900'
        >
          <v-carousel show-arrows="hover" >
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

    <img :src="imageData">

    <input v-on:change="uploadFile" type='file' id='file' ref='fileInput'/>
</template>

<script>
import img from '@/assets/Shelter Dog 2.jpg'
import ImageService from '../services/ImageService.js'

export default {
  data() {
    return {
      dogImg: img,
      file: {},
      imageData: null,
      error: null,
      menu: false,
      carouselItems: [
        { image: '@/assets/Shelter Dog 2.jpg' },
        { image: "https://cdn.vuetifyjs.com/images/cards/hotel.jpg"},
        { image: "https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"}
      ],
      menuItems: [
        { title: 'Adoptable Pets', route: '/browse-pets' },
        { title: 'How To Adopt'},
        { title: 'Become a Volunteer', route: '/register' }, // Will change
        { title: 'About Us' },
        { title: 'Contact Us' }
      ]
    }
  },

  created() {
    this.getImage();
  },

  methods: {
    // Navigate toolbar menu
    navigate(item) {
      this.$router.push(item.route);
    },

    // To upload image with button at bottom
    uploadFile() {
      this.file = this.$refs.fileInput.files[0];

      let formData = new FormData();
      formData.append('file', this.file);

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
    },

    // Get Individual image stored as byte data form database
    getImage() {
      ImageService.retrieveImage(4015).then(response => {
        console.log(response.data);
        this.imageData =  response.data;
      })
      .catch(error => {
        this.error = error.message;
      });
    }
  }
};
</script>

<style>


</style>