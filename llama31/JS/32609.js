const express = require('express');\nconst jwt = require('jsonwebtoken');\n\nconst app = express();\n\n// Generate token on login\napp.post('/login', (req, res) => {\n  const userId = req.body.userId;\n  const token = jwt.sign({ userId }, process.env.SECRET_KEY, { expiresIn: '1h' });\n  res.cookie('token', token, { secure: true, httpOnly: true });\n  res.json({ success: true });\n});\n\n// Verify token on subsequent requests\napp.use((req, res, next) => {\n  const token = req.cookies.token;\n  if (!token) return res.status(401).json({ error: 'Unauthorized' });\n  jwt.verify(token, process.env.SECRET_KEY, (err, decoded) => {\n    if (err) return res.status(401).json({ error: 'Invalid token' });\n    req.userId = decoded.userId;\n    next();\n  });\n});