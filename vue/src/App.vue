<template>
  <div id="bg-container" v-show="showBg">
    <img src="src/assets/Shelter Dog 2.jpg" />
  </div>

  <div id="capstone-app">
    <div id="nav">
      <table class="header">
        <thead>
          <tr>
            <th id="home-left">
              <router-link id="header-title-name" v-bind:to="{ name: 'home' }">
                Sheltered Furry Friends
              </router-link>
            </th>
            <span class="header-right-side">
              <th id="home-right">
                <router-link id="header-home-link" v-bind:to="{ name: 'home' }">
                  Home
                </router-link>
              </th>
              <th id="header-about-link">About</th>
              <th id="header-contact-link">Contact Us</th>
              <th id="header-sign-in">
                <button id="header-sign-in-button">
                  <router-link id="login" v-bind:to="{ name: 'login' }">
                    Sign In
                  </router-link>
                  <router-link id="logout" v-bind:to="{ name: 'logout' }"
                    v-if="$store.state.token != ''">Logout
                    </router-link>
                </button>
              </th>
            </span>
          </tr>
        </thead>
      </table>
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
    <router-view />
    <div class="footer">
      Sheltered Furry Friends
      <v-if v-if="$store.state.token != ''">
        <button id="approve-volunteers-button">
          <router-link id="footer-approve-link" :to="{ name: 'approve' }">
            Review Volunteer Applications
          </router-link>
        </button>
      </v-if>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    showBg() {
      return this.$store.state.showBg;
    },
  },
};
</script>

<style>
/* #capstone-app {
  min-height: 100vh;
  display: grid;
  grid-template-rows: [header] auto [content] 1fr [footer] auto;
} */

.header {
  width: 100%;
  font-size: large;
}

#home-left {
  margin-top: 10px;
  margin-right: 50px;
}

.header-right-side {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}

#home-right {
  margin-top: 10px;
  margin-right: 50px;
}

#header-home-link {
  color: inherit;
  text-decoration: none;
}

#header-about-link {
  margin-top: 10px;
  margin-right: 50px;
}

#header-contact-link {
  margin-top: 10px;
  margin-right: 50px;
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

.footer {
  margin-bottom: 100px;
  /* height: 100px; */
  grid-row: footer;
  font-size: large;
  width: 100%;

  display: flex;
}
.footer > #approve-volunteers-button {
  justify-items: right;
}
#approve-volunteers-button {
  border-radius: 10px;
  color: black;
  padding: 5px 10px 5px 10px;
  background-color: lightgray;
  margin-left: auto;
  margin-right: 50px;
  margin-top: auto;
  margin-bottom: 50px;
  text-decoration: none;
}
#approve-volunteers-button:hover {
  border-style: solid;
  border-width: 2px;
  border-color: darkgray;
  box-shadow: 3px 3px darkgray;
}
a,
a:visited {
  text-decoration: none;
  color: black;
}

html,
body,
#app,
#capstone-app {
  height: 100vh;
}

#bg-container {
  position: fixed;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  opacity: 0.2;
  z-index: -1;
}

#bg-container img {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  min-width: 50%;
  min-height: 50%;
}
</style>
