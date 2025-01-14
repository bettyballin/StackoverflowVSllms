// JavaScript Client-side WebSocket example\n    var ws = new WebSocket('ws://example.com/socket');\n\n    ws.onopen = function() {\n        console.log('Connected to server');\n    };\n\n    ws.onmessage = function(event) {\n        console.log('Message from server:', event.data);\n    };\n\n    ws.onerror = function(error) {\n        console.error('WebSocket Error ', error);\n    };\n\n    ws.onclose = function() {\n        console.log('Connection closed');\n    };