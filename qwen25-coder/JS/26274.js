fetch('/api/items')\n    .then(response => response.json())\n    .then(data => console.log(data))\n    .catch(error => console.error('Error:', error));