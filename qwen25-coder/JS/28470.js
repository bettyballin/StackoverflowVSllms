// JavaScript Client-side SSE example\n    var eventSource = new EventSource('http://example.com/sse');\n\n    eventSource.onmessage = function(event) {\n        console.log('New message:', event.data);\n    };\n\n    eventSource.onerror = function() {\n        console.error('EventSource failed.');\n    };