// Assuming you're using Fetch API for AJAX calls\n\nfunction getUserData(userEmail) {\n    return fetch(`/api/user/data?email=${encodeURIComponent(userEmail)}`)\n        .then(response => response.json())\n        .then(data => {\n            // Use the data to update the UI or perform other logic\n            document.getElementById('userName').innerText = data.name;\n            document.getElementById('userEmail').innerText = data.email;\n        })\n        .catch(error => console.error('Error:', error));\n}\n\n// Usage:\ngetUserData('example@example.com');