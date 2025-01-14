const express = require('express');\nconst WebSocket = require('ws');\n\nconst app = express();\nconst wss = new WebSocket.Server({ noServer: true });\n\n// Serve static files (e.g., index.html)\napp.use(express.static('public'));\n\n// Upgrade HTTP server to WebSocket\nconst server = app.listen(8080, () => {\n    console.log('Server started on port 8080');\n});\n\nserver.on('upgrade', (request, socket, head) => {\n    wss.handleUpgrade(request, socket, head, function done(ws) {\n        wss.emit('connection', ws, request);\n    });\n});\n\n// WebSocket connections\nwss.on('connection', (ws) => {\n    console.log('New client connected');\n\n    ws.on('message', (data) => {\n        // Broadcast data to other clients\n        wss.clients.forEach(function each(client) {\n            if (client !== ws && client.readyState === WebSocket.OPEN) {\n                client.send(data);\n            }\n        });\n    });\n\n    ws.on('close', () => {\n        console.log('Client disconnected');\n    });\n});