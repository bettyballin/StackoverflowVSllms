fetch('https://example.com/resource/1', {\n    method: 'PUT',\n    headers: {\n        'Content-Type': 'application/json'\n    },\n    body: JSON.stringify({ key: 'value' })\n})\n.then(response => response.json())\n.then(data => console.log(data))\n.catch(error => console.error('Error:', error));