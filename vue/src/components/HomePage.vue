<template>
    <div class="body">
        <table class="header">
            <thead>
            <tr>
                <th id="header-title-name"> Sheltered Furry Friends</th>
                <th id="header-home-link"> Home </th>
                <th id="header-about-link"> About </th>
                <th id="header-contact-link"> Contact Us</th>
                <th id="header-signup"> 
                    <button id="header-signup-button"> Sign Up </button> 
                </th>
            </tr>
            </thead>
        </table>

        <div class="splash-main-text"> 
            <h1 id="splash-title"> Sheltered Furry Friends </h1>
            <span id="sub-title"> Volunteer and save a life! </span>
            <span id="splash-signup"> 
                <button id="splash-signup-button"> Sign Up  </button>
            </span>
        </div>

        <div class="splash-hero-image" > 
            <img src="../assets/Shelter Dog 2.jpg"/>
        </div>

        <div class="splash-secondary-text"> 
            <h2 id="secondary-title"> How To Help </h2>
            <span id="secondary-sub-title"> Get involved with Sheltered Furry Friends</span>
        </div>

        <div> </div>

    </div>
</template>

<script>

</script>

<style>


.header {
    width: 100%;
}

#header-signup-button {
    border-radius: 25px;
    padding: 10px;
    background-color: black;
    color: white;
}

.splash-main-text {
    display: flex;
    flex-direction: column;

}

#splash-signup-button {
    border-radius: 25px;
    padding: 10px;
    background-color: black;
    color: white;
}

img {
    width: 100%;
    height: auto;
}

</style>