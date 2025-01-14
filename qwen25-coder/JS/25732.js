const jwt = require('jsonwebtoken');\nconst bcrypt = require('bcrypt');\n\n// Example user data stored securely in a database\nconst users = {\n    'username': {\n        salt: '$2b$10$vI8aWBnW3fID.ZQ4/zo1G.q1lRps.9cGLcZEiGDMVr5yUP1KUOYTa', // Example salt\n        hash: '$2b$10$vI8aWBnW3fID.ZQ4/zo1G.q1lRps.9cGLcZEiGDMVr5yUP1KUOYTa' // Example hash of password 'password'\n    }\n};\n\nasync function authenticateUser(username, password) {\n    const user = users[username];\n    if (user && await bcrypt.compare(password, user.hash)) {\n        // Generate JWT token\n        return jwt.sign({ username: username }, process.env.JWT_SECRET, { expiresIn: '1h' });\n    } else {\n        throw new Error('Authentication failed');\n    }\n}