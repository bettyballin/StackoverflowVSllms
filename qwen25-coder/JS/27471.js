const socket = new WebSocket('ws://localhost:8080');\n\nsocket.onmessage = function(event) {\n    console.log("New message from server:", event.data);\n};