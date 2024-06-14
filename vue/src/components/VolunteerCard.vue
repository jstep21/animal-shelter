<!-- <template>
<v-container class="d-flex align-center justify-center fill-height">
    <v-list>
        <v-list-item-group >
            <v-list-item v-for="(volunteer, index) in volunteers" :key="index">
                <v-list-item-content>
                    <v-list-item-title>{{ volunteer.firstName }}{{ volunteer.lastName }}</v-list-item-title>
                    <v-list-item-subtitle>Email: {{ volunteer.email }}</v-list-item-subtitle>
                    <v-list-item-subtitle>Phone: {{ volunteer.phoneNumber }}</v-list-item-subtitle>
                    <v-list-item-subtitle>Zip Code: {{ volunteer.zipCode }}</v-list-item-subtitle>
                </v-list-item-content>
            </v-list-item>
        </v-list-item-group>
    </v-list>
</v-container>
</template> -->

  <template>
    <div class="volunteer-card">
      <table id="volunteer-info">
        <thead id="volunteer-head">
          <tr>
            <th class="column-header">Name</th>
            <th class="column-header">Email</th>
            <th class="column-header">Phone Number</th>
            <th class="column-header">Zip Code</th>
          </tr>
        </thead>
        <tbody id="volunteer-body">
          <tr v-for="volunteer in volunteers" :key="volunteer.volunteerId">
            <td>{{ volunteer.firstName }} {{ volunteer.lastName }}</td>
            <td>{{ volunteer.email }}</td>
            <td>{{ volunteer.phoneNumber }}</td>
            <td>{{ volunteer.zipCode }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>

<script> 
import VolunteerService from '../services/VolunteerService';

export default {

  data() {
        return {
            volunteers: []
        };
    },
    methods: {
        showAllVolunteers() {
            VolunteerService.getAllVolunteers().then( (response) => {
                this.volunteers = response.data;
                console.log(this.volunteers)
            })
            .catch((error) => {
                console.error("Error retrieving volunteer data", error)
            })
        }
    },
    created() {
        this.showAllVolunteers();
    }
};
</script>


<style> 

.column-header, #volunteer-body td {
  padding: 15px; 
  text-align: center; 
}
</style>