const express = require('express');\nconst jwt = require('jsonwebtoken');\n\nconst app = express();\n\n// Set session duration to 2 weeks\nconst sessionDuration = 14 * 24 * 60 * 60 * 1000; // 2 weeks in milliseconds\n\n// Generate a secure token\nconst generateToken = (user) => {\n  const token = jwt.sign(user, process.env.SECRET_KEY, {\n    expiresIn: sessionDuration,\n  });\n  return token;\n};\n\n// Verify the token on each request\nconst authenticate = (req, res, next) => {\n  const token = req.cookies['session-token'];\n  if (!token) {\n    return res.status(401).send('Unauthorized');\n  }\n  jwt.verify(token, process.env.SECRET_KEY, (err, user) => {\n    if (err) {\n      return res.status(401).send('Unauthorized');\n    }\n    req.user = user;\n    next();\n  });\n};\n\n// Use the authenticate middleware on protected routes\napp.get('/protected', authenticate, (req, res) => {\n  // Only authorized users can access this route\n  res.send('Hello, authenticated user!');\n});