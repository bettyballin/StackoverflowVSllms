const express = require('express');\nconst https = require('https');\nconst fs = require('fs');\nconst path = require('path');\n\nconst app = express();\n\n// Assuming you have your certificate and keys generated\nconst options = {\n  key: fs.readFileSync(path.join(__dirname, 'ssl/key.pem')),\n  cert: fs.readFileSync(path.join(__dirname, 'ssl/cert.pem'))\n};\n\napp.get('/', (req, res) => {\n  res.send('Welcome to my community site!');\n});\n\nhttps.createServer(options, app).listen(443, () => {\n  console.log('Secure server up and running at https://localhost');\n});