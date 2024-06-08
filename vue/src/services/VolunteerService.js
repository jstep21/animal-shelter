import axios from 'axios';

export default {

  getAllVolunteers() {
    const API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.get(`${API_BASE_URL}/volunteers`)
  },

  postVolunteer(volunteer, options) {
    const API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.post('/volunteers', volunteer, options);
  }

}
