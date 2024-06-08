import axios from 'axios';

export default {

  getAllVolunteers() {
    const API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.get(`${API_BASE_URL}/volunteers`)
  },

  postVolunteer(formData, options) {
    const API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.post('/volunteers', formData, options);
  }

}
