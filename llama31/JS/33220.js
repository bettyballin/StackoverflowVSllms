const express = require('express');\nconst app = express();\n\napp.post('/track_download', (req, res) => {\n  const file = req.body.file;\n  // Update download count in your database or log file\n  console.log(`Downloaded: ${file}`);\n  res.send('OK');\n});