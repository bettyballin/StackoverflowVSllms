const http = require('http');\n\nhttp.createServer((req, res) => {\n    res.setHeader('Access-Control-Allow-Origin', 'http://mydomain.example');\n    res.writeHead(200, {'Content-Type': 'text/plain'});\n    res.end('Hello from port 81!');\n}).listen(81);