fetch('https://api.example.com/submit', {\n    method: 'POST',\n    headers: {\n        'Content-Type': 'application/json'\n    },\n    body: JSON.stringify({ password: 'userpassword' })\n})\n.then(response => response.json())\n.then(data => console.log(data))\n.catch(error => console.error('Error:', error));