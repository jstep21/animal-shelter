import axios from 'axios';

export default {

  getAllImages() {
    let API_BASE_URL = import.meta.env.VITE_REMOTE_API
    return axios.get(`${API_BASE_URL}/all-images`)
  },

  postImage(formData, petId, options) {

    return axios.post(`/upload?petId=${petId}`, formData, options);
  },

  retrieveImages(id, headers) {
    return axios.get(`/retrieve-images?petId=${id}`, headers);
  }
}
