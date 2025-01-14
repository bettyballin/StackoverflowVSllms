fetch('http://www.somesite.com', {\n    method: 'POST',\n    headers: {\n        'Content-Type': 'application/json'\n    },\n    body: JSON.stringify({ key: 'value' })\n})\n.then(response => console.log('Success:', response))\n.catch(error => console.error('Error:', error));