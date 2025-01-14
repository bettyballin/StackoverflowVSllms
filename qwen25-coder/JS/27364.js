// Example HTTPS configuration in Node.js\n   const https = require('https');\n   const fs = require('fs');\n\n   const options = {\n       key: fs.readFileSync('./key.pem'),\n       cert: fs.readFileSync('./cert.pem')\n   };\n   https.createServer(options, (req, res) => {\n       res.writeHead(200);\n       res.end('Hello Secure World\n');\n   }).listen(443);