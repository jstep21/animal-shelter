import { createApp } from 'vue'
import CapstoneApp from './App.vue'
import { createStore } from './store'
import router from './router'
import axios from 'axios'// Vuetify
// import 'vuetify/styles'
// import { createVuetify } from 'vuetify'
// import { aliases, mdi } from 'vuetify/iconsets/mdi-svg'
// import * as components from 'vuetify/components'
// import * as directives from 'vuetify/directives'



/* sets the base url for server API communication with axios */
axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;

/*
 * The authorization header is set for axios when you login but what happens when 
 * you come back or the page is refreshed. When that happens you need to check 
 * for the token in local storage and if it exists you should set the header 
 * so that it will be attached to each request.
 */
let currentToken = localStorage.getItem('token');
let currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken) {
  // Set token axios requests
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

// Create the Vuex store passing in the stored credentials
const store = createStore(currentToken, currentUser);

// const vuetify = createVuetify({
//   components,
//   directives,
//   icons: {
//     defaultSet: 'mdi',
//     aliases,
//     sets: {
//       mdi,
//     },
//   },
// })

const app = createApp(CapstoneApp);
app.use(store);
// app.use(vuetify);
app.use(router);
app.mount('#app');