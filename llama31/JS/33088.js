const express = require('express');\nconst app = express();\nconst server = require('http').createServer(app);\nconst io = require('socket.io')(server);\n\napp.get('/', (req, res) => {\n  res.sendFile(__dirname + '/index.html');\n});\n\nio.on('connection', (socket) => {\n  console.log('a user connected');\n\n  // Pair the user with a random stranger\n  const strangerSocket = io.sockets.adapter.rooms['stranger'];\n  if (strangerSocket) {\n    socket.join('stranger');\n    strangerSocket.emit('newMessage', 'You have been paired with a new stranger!');\n  }\n\n  socket.on('message', (msg) => {\n    // Broadcast the message to the paired stranger\n    strangerSocket.emit('newMessage', msg);\n  });\n\n  socket.on('disconnect', () => {\n    // Pair the remaining user with a new stranger\n    const newStrangerSocket = io.sockets.adapter.rooms['stranger'];\n    if (newStrangerSocket) {\n      newStrangerSocket.emit('newMessage', 'You have been paired with a new stranger!');\n    }\n  });\n});\n\nserver.listen(3000, () => {\n  console.log('listening on *:3000');\n});