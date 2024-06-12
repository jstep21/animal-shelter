import axios from 'axios';
import UpdatePasswordViewVue from '../views/UpdatePasswordView.vue';
import UpdatePasswordVue from '../components/UpdatePassword.vue';

export default {

  getAllVolunteers() {
    const API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.get(`${API_BASE_URL}/volunteers`)
  },

  postVolunteer(volunteer, options) {
    const API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.post('/volunteers', volunteer, options);
  },

  updateVolunteer(volunteer, options) {
    const API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.put('/volunteers', volunteer, options);
  },
  updatePassword(newPassword) {
    const API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.post(`${API_BASE_URL}/update-password`, { password: newPassword });
  }
};