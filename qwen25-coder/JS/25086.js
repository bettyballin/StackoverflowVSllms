const express = require('express');\nconst app = express();\n\napp.get('/status-stream', (req, res) => {\n    res.setHeader('Content-Type', 'text/event-stream');\n    res.setHeader('Cache-Control', 'no-cache');\n    res.setHeader('Connection', 'keep-alive');\n\n    // Simulate sending updates\n    const intervalId = setInterval(() => {\n        res.write(`data: ${JSON.stringify({status: 'processing', progress: Math.floor(Math.random() * 100)})}\n\n`);\n    }, 2000);\n\n    req.on('close', () => {\n        clearInterval(intervalId);\n        res.end();\n    });\n});\n\napp.listen(3000, () => console.log('Server is running on port 3000'));