<template>
  <div id="capstone-app">
    <div id="nav">
      <table class="header">
      <thead>
        <tr>
          <th><router-link id="header-title-name" v-bind:to="{ name: 'home' }"> Sheltered Furry Friends </router-link></th>
          <th id="header-home-link">Home</th>
          <th id="header-about-link">About</th>
          <th id="header-contact-link">Contact Us</th>
          <th id="header-sign-in">
            <button id="header-sign-in-button">
              <router-link id="login" v-bind:to="{ name: 'login' }"> Sign In </router-link>
              <router-link id="logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != '' ">Logout</router-link>
            </button>
          </th>
        </tr>
      </thead>
    </table>
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
    <router-view />
  </div>
</template>

<style>

.header {
  width: 100%;
  font-size: large;
}

#header-sign-in-button {
  border-radius: 25px;
  padding: 10px;
  background-color: black;  
}

#header-title-name {
  display: flex;
  justify-content: flex-start;
  color: inherit; 
  text-decoration: none;
}

#login {
  color: white;
  text-decoration: none;
}

</style>
