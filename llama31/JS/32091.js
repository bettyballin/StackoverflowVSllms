const jwt = require('jsonwebtoken');\nconst secretKey = 'your_secret_key_here';\n\n// Generate token\nconst user = { id: 1, username: 'johnDoe' };\nconst token = jwt.sign(user, secretKey, { expiresIn: '1h' });\n\n// Validate token\nconst validateToken = (token) => {\n  try {\n    const decoded = jwt.verify(token, secretKey);\n    return decoded;\n  } catch (err) {\n    return null;\n  }\n};