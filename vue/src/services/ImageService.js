import axios from 'axios';

export default {

  getAllImages() {
    let API_BASE_URL = process.env.VITE_REMOTE_API
    return axios.get(`${API_BASE_URL}/all-images`)
  },

  postImage(formData, options) {

    return axios.post('/upload', formData, options);
  }

}
