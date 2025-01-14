// Fetch data from a REST API (GET request)\nfetch('https://api.example.com/items')\n    .then(response => response.json())\n    .then(data => console.log(data));\n\n// Create new data (POST request)\nfetch('https://api.example.com/items', {\n    method: 'POST',\n    headers: {'Content-Type': 'application/json'},\n    body: JSON.stringify({name: 'NewItem', description: 'This is a new item.'})\n})\n.then(response => response.json())\n.then(newItem => console.log(newItem));\n\n// Update existing data (PUT request)\nfetch('https://api.example.com/items/123456', {\n    method: 'PUT',\n    headers: {'Content-Type': 'application/json'},\n    body: JSON.stringify({name: 'UpdatedItem', description: 'This item has been updated.'})\n})\n.then(response => response.json())\n.then(updatedItem => console.log(updatedItem));\n\n// Delete data (DELETE request)\nfetch('https://api.example.com/items/123456', {\n    method: 'DELETE'\n})\n.then(response => console.log('Delete successful:', response.ok));