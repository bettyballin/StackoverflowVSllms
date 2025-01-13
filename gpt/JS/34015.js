async function login(username, password) {\n        const response = await fetch('/login', {\n            method: 'POST',\n            headers: {\n                'Content-Type': 'application/json',\n            },\n            body: JSON.stringify({ username, password }),\n        });\n\n        if (response.ok) {\n            const data = await response.json();\n            localStorage.setItem('token', data.token); // Store the token securely\n        } else {\n            console.error('Login failed');\n        }\n    }