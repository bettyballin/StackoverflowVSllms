fetch('https://api.googleapis.com/customsearch/v1?q=YOUR_QUERY&key=YOUR_API_KEY')\n    .then(response => response.json())\n    .then(data => console.log(data))\n    .catch(error => console.error('Error:', error));