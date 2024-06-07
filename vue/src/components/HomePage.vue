<template>
  <div class="body">
    <div class="splash-main-text">
      <h1 id="splash-title">Sheltered Furry Friends</h1>
      <span id="sub-title"> Volunteer and save a life! </span>
        <button id="splash-signup-button">
           <router-link class="signup" v-bind:to="{ name: 'apply'}"> Sign Up </router-link> 
        </button>
    </div>
    
    <div class="splash-hero-image">
      <img src="../assets/Shelter Dog 2.jpg" />
    </div>

    <div class="splash-secondary-text">
      <h2 id="secondary-title">How To Help</h2>
      <span id="secondary-sub-title">
        Get involved with Sheltered Furry Friends</span
      >
    </div>

    <br>
    <br>

    <div class="links-box">
      <div class="links-card">
        <div><strong>Find your newest family member!</strong></div>
        <button id="search-adoptees-button" @click="goToBrowsePets">
            Search available adoptees
        </button>
      </div>
      <div class="links-card">
        <div><strong>Volunteer at a shelter!</strong></div>
        <button id="volunteer-signup-button">
            <router-link class="signup" v-bind:to="{ name: 'apply'}"> Sign up to be a volunteer </router-link>
        </button>
      </div>
      <div class="links-card">
        <div><strong>Tell your friends about us!</strong></div>
        <button id="invite-friend-button">Invite a friend</button>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        methods: {
            goToBrowsePets() {
                this.$router.push({ name: 'browse-pets'});
            }
        }
    }
</script>

<style scoped>

.splash-main-text {
  display: flex;
  flex-direction: column;
  align-items: center;
  
 
}

#splash-signup-button {
  border-radius: 25px;
  padding: 10px;
  background-color: black;
  color: white;
  margin-bottom: 50px;
  margin-top: 10px;
}

.signup {
  color: white;
  text-decoration: none;
}
.splash-secondary-text {
    margin-left: 10px;
}

#sub-title {
  font-size: large;
}

#secondary-title {
  font-size: xx-large;
  margin-top: 50px;
}

#secondary-sub-title {
  color: #626e72;
  font-size: large;
}

#invite-friend-button {
  margin-left: 75px;
}

.splash-hero-image {
  display: flex;
  align-content: center;
  justify-content: center;
}

img {
  width: 50%;
  height: 40%;
}

.links-box {
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100%;
  font-size:x-large;
  
}
.links-box button {
  border-radius: 15px;
  padding: 10px;
  background-color: black;
  color: white;
  font-size: large;
}
.links-card {
  display:flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: space-around;
  /* border: solid lightgray 3px;
  padding: 5px; */
  padding: 10px;
    border: 1px solid #767e8b;
    box-shadow:  -1px 1px #767e8b,
         -2px 2px #767e8b,
         -3px 3px #767e8b,
         -4px 4px #767e8b,
         -5px 5px #767e8b;
 }
.links-card > *:not(:last-child) {
    margin-bottom: 20px;
}
</style>
