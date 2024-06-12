<template>
  <div>
    <v-text-field v-model="search" label="Search" clearable @input="applyFilter"></v-text-field>
  </div>
  <div>
    <v-responsive>


    <v-data-table
      :items="filteredVolunteers"
      item-key="volunteerId"
      items-per-page="25"
    >
      <template v-slot:item="{ item }">
        <tr v-if='item.approvalStatus === "Pending"'>
          <td v-for="(value, key) in item" :key="key">{{ value }}</td>

          <td>
            <v-btn color="primary" @click="approve(item)">
              Approve
            </v-btn>
          </td>
          <td>
            <v-btn color="primary" @click="decline(item)">
              Decline
            </v-btn>
          </td>
        </tr>
      </template>
    </v-data-table>
  </v-responsive>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";
import homePageDogPic from "@/assets/Shelter Dog 2.jpg";

export default {
  components: {},
  data() {
    return {
      search: '',
      volunteers: []
    };
  },

  computed: {
    filteredVolunteers() {
      if (this.search === '') {
        return this.volunteers;
      }
      console.log(this.search);
      const searchWords = this.search.toLowerCase();
      return this.volunteers.filter(
        volunteer => Object.values(volunteer).some(
          value => String(value).toLowerCase().includes(searchWords)
        )
      );
    },

    // Was trying to use this for the headers in the table instead of the keys from item.
    headers() {
      return [
        { text: 'Volunteer Id', value: 'volunteerId' },
        { text: 'User Id', value: 'userId' },
        { text: 'First Name', value: 'firstName' },
        { text: 'Last Name', value: 'lastName' },
        { text: 'Email Address', value: 'email' },
        { text: 'Phone Number', value: 'phoneNumber' },
        { text: 'Zip Code', value: 'zipCode' },
        { text: 'Approval Status', value: 'approvalStatus' },
      ]
    }
  },

  methods: {
    fetchVolunteers() {
      volunteerService
        .getAllVolunteers()
        .then((response) => {
          this.volunteers = response.data
          console.log(this.volunteers);
        })
        .catch((error) => {
          console.error("Error fetching volunteers: ", error);
        });
    },
    approve(volunteer) {
      console.log("in approve() method..."); //////
      this.adjudicate(volunteer, "Approved");
    },
    decline(volunteer) {
      console.log("in decline() method..."); //////
      this.adjudicate(volunteer, "Declined");
    },
    adjudicate(volunteer, decision) {
      const options = {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
      };
      console.log("in adjudicate() method..."); //////
      console.log("decision: ", decision); //////

      volunteer.approvalStatus = decision;

      volunteerService
        .updateVolunteer(volunteer, options)
        .then((response) => {
          console.log(
            "PUT completed, in .then(), response status is: " + response.status
          ); //////

          if (response.status >= 200 && response.status < 300) {
            // this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            // this.$store.commit("SET_USER", response.data.user); 
            alert("Successfully updated status for: " + volunteer.firstName + " " + volunteer.lastName)  // Alerts user of successful update
            console.log("should redirect to home now... response: ", response); //////

            this.$router.push({ name: "home" });  // Are you sure we want to push them Home? 
                                                  // what if they want to approve multiple?
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    applyFilter() {

    }
  },
  created() {
    this.fetchVolunteers();
    this.$store.commit("SET_BG", true);
  }
};
</script>

<style scoped>
</style>