// Get the anchor part of the URL\nvar anchor = window.location.hash.substring(1); // Removes the '#' symbol\n\n// Send it to the server via an AJAX request, for example\nfetch('something.php', {\n    method: 'POST',\n    headers: {\n        'Content-Type': 'application/x-www-form-urlencoded',\n    },\n    body: 'anchor=' + encodeURIComponent(anchor)\n})\n.then(response => response.text())\n.then(data => console.log(data))\n.catch(error => console.error('Error:', error));