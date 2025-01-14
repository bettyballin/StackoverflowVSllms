// Client-side SSE code\nconst eventSource = new EventSource('http://example.com/sse');\n\neventSource.onmessage = function(event) {\n    console.log('New message:', event.data);\n};\n\neventSource.onerror = function(err) {\n    console.error("EventSource failed:", err);\n};