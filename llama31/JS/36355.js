import axios from 'axios';\n\naxios.get('/api/data')\n  .then(response => console.log(response.data))\n  .catch(error => console.error(error));