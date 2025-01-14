const express = require('express');\nconst http = require('http');\nconst socketIo = require('socket.io');\n\nconst app = express();\nconst server = http.createServer(app);\nconst io = socketIo(server);\n\nlet activeSockets = [];\n\nio.on('connection', (socket) => {\n    // Pairing logic\n    if (activeSockets.length % 2 === 0) {\n        socket.pair = null;\n        console.log('No pair found. Waiting...');\n    } else {\n        socket.pair = activeSockets[activeSockets.length - 1];\n        socket.pair.pair = socket;\n        socket.pair.emit('paired', { id: socket.id });\n        socket.emit('paired', { id: socket.pair.id });\n        console.log(`Paired sockets ${socket.id} and ${socket.pair.id}`);\n    }\n    activeSockets.push(socket);\n\n    // Listening to messages from a user\n    socket.on('message', (msg) => {\n        if (socket.pair) {\n            socket.pair.emit('message', msg);\n        }\n    });\n\n    // Handling disconnection and re-pairing logic\n    socket.on('disconnect', () => {\n        console.log(`Socket ${socket.id} has disconnected`);\n        activeSockets = activeSockets.filter(s => s !== socket);\n        if (socket.pair) {\n            socket.pair.emit('disconnected');\n            socket.pair.pair = null;\n        }\n    });\n});\n\nserver.listen(3000, () => {\n    console.log('Server is running on port 3000');\n});