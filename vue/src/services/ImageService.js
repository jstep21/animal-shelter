import axios from 'axios';

export default {

  getAllImages() {
    let API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.get(`${API_BASE_URL}/all-images`)
  },

  postImage(formData, petId, options) {

    return axios.post(`/upload?petId=${petId}`, formData, options);
  },

  retrieveImage(id) {
    return axios.get(`/retrieve-image?id=${id}`);
  }
}
