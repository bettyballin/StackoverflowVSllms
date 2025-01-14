const http = require('http');\nconst httpProxy = require('http-proxy');\n\nconst proxy = httpProxy.createProxyServer({});\n\nconst server = http.createServer((req, res) => {\n    console.log('Request URL:', req.url);\n    proxy.web(req, res, { target: 'http://your-target-server.com' });\n});\n\nserver.listen(8000, () => {\n    console.log('Proxy server listening on port 8000');\n});