// Create a WebSocket connection to the server\nconst socket = new WebSocket('ws://example.com/socket');\n\nsocket.onopen = function() {\n    console.log('WebSocket connection established');\n};\n\nsocket.onmessage = function(event) {\n    console.log('Data received from server:', event.data);\n};\n\nsocket.onerror = function(error) {\n    console.error('WebSocket error observed:', error);\n};\n\nsocket.onclose = function() {\n    console.log('WebSocket closed');\n};