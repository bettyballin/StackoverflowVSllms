fetch('https://api.example.com/data', {\n    method: 'GET',\n    headers: {\n        'Content-Type': 'application/json',\n        'Authorization': 'Bearer ' + localStorage.getItem('authToken')\n    }\n})\n.then(response => response.json())\n.then(data => console.log(data))\n.catch(error => console.error('Error:', error));