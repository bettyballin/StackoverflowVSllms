const express = require('express');\nconst app = express();\n\napp.get('/sse', (req, res) => {\n    res.setHeader('Content-Type', 'text/event-stream');\n    res.setHeader('Cache-Control', 'no-cache');\n    res.setHeader('Connection', 'keep-alive');\n\n    setInterval(() => {\n        res.write(`data: ${new Date().toLocaleTimeString()}\n\n`);\n    }, 1000);\n});\n\napp.listen(3000, () => {\n    console.log('SSE server listening on port 3000');\n});