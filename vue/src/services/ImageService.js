import axios from 'axios';

export default {

  postImage(formData, options) {

    return axios.post('/upload', formData, options);
  }

}
