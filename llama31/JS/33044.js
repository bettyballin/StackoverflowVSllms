const express = require('express');\nconst app = express();\n\n// Data-oriented web service\napp.get('/api/user-data/:email', (req, res) => {\n  const userEmail = req.params.email;\n  // Validate and sanitize userEmail\n  const userData = getUserData(userEmail);\n  res.json(userData);\n});\n\n// Business logic to retrieve user data\nfunction getUserData(userEmail) {\n  // Implement data validation, sanitization, and retrieval logic here\n  return { /* user data */ };\n}