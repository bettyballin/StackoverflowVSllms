function longPollServer() {\n     fetch('/long-poll-endpoint')\n       .then(response => response.json())\n       .then(data => {\n         console.log('New message:', data.message);\n         longPollServer(); // Immediately poll again\n       });\n   }\n\n   longPollServer();