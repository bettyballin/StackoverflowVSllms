fetch('https://your-server.com/api/resource', {\n       method: 'GET',\n       headers: {\n           'Authorization': 'Bearer ' + token\n       }\n   })\n   .then(response => response.json())\n   .then(data => console.log(data))\n   .catch(error => console.error('Error:', error));