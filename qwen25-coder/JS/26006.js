// Create a WebSocket object\nvar socket = new WebSocket('ws://example.com/socket');\n\n// Open the connection and handle events\nsocket.onopen = function() {\n    console.log("WebSocket is open now.");\n    // You can send data to server directly from here\n    socket.send('Hello Server!');\n};\n\nsocket.onmessage = function(event) {\n    console.log("Message from server ", event.data);\n    // Handle the data and update your web page\n};\n\nsocket.onerror = function(error) {\n    console.error("WebSocket error observed:", error);\n};\n\nsocket.onclose = function() {\n    console.log("WebSocket is closed now.");\n};\n\n// Function to send data through the WebSocket connection\nfunction sendData(data) {\n    if (socket.readyState === WebSocket.OPEN) {\n        socket.send(JSON.stringify(data));\n    }\n}