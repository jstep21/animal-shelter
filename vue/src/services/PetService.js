import axios from 'axios';

export default {

  getPet(petId) {
    const apiBaseUrl = import.meta.env.VITE_REMOTE_API;
    return axios.get(`${apiBaseUrl}/pets/${petId}`);
  },
  getAllPets() {
    const apiBaseUrl = import.meta.env.VITE_REMOTE_API;
    return axios.get(`${apiBaseUrl}/pets`);
  }

}
