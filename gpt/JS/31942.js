document.getElementById('loginForm').addEventListener('submit', function(event) {\n    event.preventDefault();\n    // Add client-side validation and additional security checks here\n    fetch('/login', {\n        method: 'POST',\n        headers: {\n            'Content-Type': 'application/json'\n        },\n        body: JSON.stringify({\n            username: document.getElementById('username').value,\n            password: document.getElementById('password').value\n        })\n    }).then(response => response.json())\n      .then(data => {\n          if(data.success) {\n              window.location.href = '/dashboard';\n          } else {\n              document.getElementById('message').innerText = data.message;\n          }\n      })\n      .catch(error => console.error('Error:', error));\n});