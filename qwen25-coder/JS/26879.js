function getUserIdFromUsername(username, site='stackoverflow.com', callback) {\n    const url = `https://api.stackexchange.com/2.3/users?order=desc&sort=reputation&inname=${encodeURIComponent(username)}&site=${site}`;\n\n    fetch(url)\n        .then(response => response.json())\n        .then(data => {\n            if (data.items && data.items.length > 0) {\n                // Assuming the first match is the correct user\n                const userId = data.items[0].user_id;\n                callback(userId);\n            } else {\n                callback(null); // No user found\n            }\n        })\n        .catch(error => console.error('Error fetching user ID:', error));\n}\n\n// Example usage:\ngetUserIdFromUsername('your-username', (userId) => {\n    if (userId) {\n        console.log(`User ID: ${userId}`);\n    } else {\n        console.log('User not found');\n    }\n});