const eventSource = new EventSource('http://localhost/sse.php');\n\neventSource.onmessage = function(event) {\n    console.log('New message:', JSON.parse(event.data));\n};\n\neventSource.onerror = function(err) {\n    console.error("EventSource failed:", err);\n};