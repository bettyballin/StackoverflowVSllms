// Fetch JSON data\nfetch('/users/bob/tags/footag/received?page=1')\n  .then(response => response.json())\n  .then(data => {\n    const receivedDiv = document.getElementById('received');\n    receivedDiv.innerHTML = ''; // Clear existing content\n    \n    // Render data\n    data.users.forEach(user => {\n      const userElement = document.createElement('div');\n      userElement.textContent = user.name; // Ensure text content to avoid XSS\n      receivedDiv.appendChild(userElement);\n    });\n  })\n  .catch(error => console.error('Error fetching data:', error));