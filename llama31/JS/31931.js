const express = require('express');\nconst crypto = require('crypto');\n\nconst app = express();\n\napp.post('/login', (req, res) => {\n  const username = req.body.username;\n  const password = req.body.password;\n\n  // Verify username and password\n\n  const token = crypto.randomBytes(32).toString('hex');\n  req.session.token = token;\n\n  res.json({ token });\n});