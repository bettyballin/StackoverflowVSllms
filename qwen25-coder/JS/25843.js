// Example of a secure AJAX request with CORS\nfetch('http://api.example.com/getContacts', {\n    method: 'GET',\n    mode: 'cors',\n    credentials: 'same-origin'\n})\n.then(response => response.json())\n.then(data => handleResponse(data))\n.catch(error => console.error('Error:', error));