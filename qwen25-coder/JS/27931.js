var socket = new WebSocket('ws://example.com/socket');\n\nsocket.onopen = function(event) {\n    console.log('WebSocket connection opened');\n};\n\nsocket.onmessage = function(event) {\n    console.log('Message from server ', event.data);\n};\n\nsocket.onerror = function(error) {\n    console.error('WebSocket error observed:', error);\n};\n\nsocket.onclose = function(event) {\n    console.log('WebSocket connection closed');\n};