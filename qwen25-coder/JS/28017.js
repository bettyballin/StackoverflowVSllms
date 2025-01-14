// Function to send login credentials and receive a JWT\nasync function loginUser(username, password) {\n    const response = await fetch('/api/login', {\n        method: 'POST',\n        headers: {'Content-Type': 'application/json'},\n        body: JSON.stringify({username, password})\n    });\n    if (!response.ok) throw new Error('Login failed');\n    const data = await response.json();\n    localStorage.setItem('authToken', data.token); // Store token in local storage\n}\n\n// Function to make an AJAX request using the JWT for authentication\nasync function fetchData(endpoint) {\n    const token = localStorage.getItem('authToken');\n    if (!token) throw new Error('No auth token found');\n\n    const response = await fetch(endpoint, {\n        method: 'GET',\n        headers: {'Authorization': `Bearer ${token}`}\n    });\n    if (!response.ok) throw new Error('Fetch failed');\n    return await response.json();\n}