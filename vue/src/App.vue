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
            <router-link 
              id="header-title-name" 
              v-bind:to="{ name: 'home' }"
              >Sheltered Furry Friends
            </router-link>
          </th>
          <span class="header-right-side">
          <th id="home-right">
            <router-link 
              id="header-home-link" 
              v-bind:to="{ name: 'home' }"
              >Home
            </router-link>
          </th>

          <th id="about-right">
            <router-link 
              id="header-about-link"
              v-bind:to="{ name: 'about' }">About 
            </router-link>
          </th>

          <th id="header-contact-link">Contact Us</th>

          <th id="header-contact-link-short">Contact</th>


          <th 
            id="header-add-pet" 
            v-if="$store.state.token != '' "
            >
            <router-link
              to="/add-pet"
              >Add a New Pet
            </router-link> 
          </th>

          <th 
            id="header-add-pet-short" 
            v-if="$store.state.token != '' "
            >
            <router-link
              to="/add-pet"
              >Add Pet
            </router-link> 
          </th>

          <th id="header-sign-in">
            <button id="header-sign-in-button">
              <router-link 
                id="logout" 
                v-bind:to="{ name: 'logout' }" 
                v-if="$store.state.token != '' "
                >Logout
              </router-link>
              <router-link 
                id="login" 
                v-bind:to="{ name: 'login' }" 
                v-else
                >Sign In
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

   
      <div v-if="isAdmin" class="admin-and-volunteer-section">

        <v-btn id="volunteer-list-button">
          <router-link id="footer-volunteer-list-link" :to="{ name: 'volunteer-list' }">
            Volunteer Directory
          </router-link>
        </v-btn>

        <v-btn id="review-volunteers-button">
          <router-link id="footer-approve-link" :to="{ name: 'approve' }">
            Review Volunteer Applications
          </router-link>
        </v-btn>
     
        

      </div>


    <div class="footer">

      <div class="footer-left-side"> 
        <div id="footer-title"><router-link id="footer-title-name" v-bind:to="{ name: 'home' }"> Sheltered Furry Friends </router-link></div>
        <a class="icon" href="#" id="facebook"><i class="fa fa-facebook"></i></a>  
        <a class="icon" href="#" id="twitter"><i class="fa fa-twitter"></i></a> 
        <a class="icon" href="#" id="youtube"><i class="fa fa-youtube"></i></a> 
        <a class="icon" href="#" id="instagram"><i class="fa fa-instagram"></i></a>         
      </div>

      <div class="footer-right-side">
        <div id="terms-of-service"><router-link id="terms" v-bind:to="{name: 'terms-of-service'}"> Terms of Service </router-link></div>
        <div id="privacy-policy"><router-link id="privacy" v-bind:to="{name: 'privacy-policy'}"> Privacy Policy </router-link></div>
      </div>

    </div>
  </div>
</template>

<script>
import AuthService from './services/AuthService.js';

export default {
  computed: {
    showBg() {
      return this.$store.state.showBg;
    },

  },
  data() {
    return {
      isAdmin: false
    }
  },
  created() {
    this.isUserAdmin();
    this.$router.beforeEach((to, from, next) => {
      this.isUserAdmin();
      next();
    });
  },
  methods: {
    isUserAdmin() {
      AuthService.isUserAdmin().then(
        (response) => {
          console.log(response.data);
          this.isAdmin = response.data;
        }
      )
      .catch ((error) => {
        if (error.response && error.response.status === 401) {
          this.isAdmin = false;
        } else {
          console.log("Error occurred: ", error)
        }
      })
    }
  },
};

</script>

<style>

.header {
  width: 100%;
  font-size: large;
}

#header-add-pet-short {
  display: none;
}

#header-contact-link-short {
  display: none;
}

@media screen and (max-width: 800px) {
  #home-left {
    display: none;
  }
}

@media screen and (max-width: 600px) {

  .header {
    font-size: 14px;
  }
  #header-add-pet {
    display: none;
  }
  #header-add-pet-short {
    display: flex;
    margin-top: 10px;
    margin-right: 30px;
  }

  #header-contact-link {
    display: none;
  }
  #header-contact-link-short {
    display: flex;
    margin-top: 10px;
    margin-right: 30px;
  }
  tr #header-about-link {
    margin-right: 30px;
  }
  tr #home-right {
    margin-right: 30px;
  }

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

#about-right {
  margin-top: 10px;
  margin-right: 50px;
}

#header-contact-link {
  margin-top: 10px;
  margin-right: 50px;
}

#header-add-pet {
  margin-top: 10px;
  margin-right: 50px;
}


#header-sign-in-button {
  border-radius: 25px;
  padding: 10px;
  background-color: black;
  font-size: small;
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

#logout {
  color: white;
  text-decoration: none;
}


.footer {
  display: flex;
  flex-direction: row;
  margin-bottom: 100px;
  margin-top: 50px;
  font-size: large;
  width: 100%;
  justify-content: space-around;
  border-top: solid 2px;
  border-color: gray;
}

.footer-left-side {
  margin: 25px;

}

#footer-title {
  margin: 10px;
}

.icon {
  margin: 10px;
}

#facebook {
  color: blue;
}

#twitter {
  color: lightblue;
}

#youtube {
  color: red;
}

#instagram {
  color: orange;
}

.footer-right-side {
  margin: 25px;  
}

#terms-of-service {
  margin: 10px;
}

#privacy-policy {
  margin: 10px;
}

.admin-and-volunteer-section {
  display: flex;
  flex-direction: row;
  margin-top: 100px;
  font-size: large;
  width: 100%;
  justify-content: space-between;
  /* border-top: solid 2px; */
  border-color: gray;
}

.admin-and-volunteer-section > #volunteer-list-button {
  /* justify-items: right; */
}
#volunteer-list-button {
  border-radius: 10px;
  color: black;
  padding: 5px 10px 5px 10px;
  background-color: lightgray;
  margin-left: auto;
  margin-right: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  text-decoration: none;
}
#volunteer-list-button:hover {
  border-style: solid;
  border-width: 1px;
  border-color: darkgray;
  box-shadow: 3px 3px darkgray;
}

.admin-and-volunteer-section > #review-volunteers-button {
  /* justify-items: right; */
}
#review-volunteers-button {
  border-radius: 10px;
  color: black;
  padding: 5px 10px 5px 10px;
  background-color: lightgray;
  margin-left: 20px;
  margin-right: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  text-decoration: none;
}
#review-volunteers-button:hover {
  border-style: solid;
  border-width: 1px;
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
