const WebSocket = require('ws');\nconst server = new WebSocket.Server({ port: 8080 });\n\nserver.on('connection', socket => {\n    console.log('Client connected');\n    \n    // Example of sending a message when a new answer is posted\n    // This should be triggered by your application's logic\n    function notifyNewAnswer() {\n        socket.send(JSON.stringify({ newAnswers: "1 new answer" }));\n    }\n\n    // Simulate new answer notification\n    setTimeout(notifyNewAnswer, 10000); // 10 seconds for demo\n\n    socket.on('close', () => {\n        console.log('Client disconnected');\n    });\n});