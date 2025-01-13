const jwt = require('jsonwebtoken');\n\n// Generate token for a developer\nconst token = jwt.sign({\n  devId: 123,\n  exp: Math.floor(Date.now() / 1000) + 3600 // expires in 1 hour\n}, process.env.SECRET_KEY);\n\n// Verify token on each request\nconst verifyToken = (req, res, next) => {\n  const token = req.headers.authorization.split(' ')[1];\n  jwt.verify(token, process.env.SECRET_KEY, (err, payload) => {\n    if (err) {\n      return res.status(401).send({ error: 'Invalid token' });\n    }\n    req.devId = payload.devId;\n    next();\n  });\n};