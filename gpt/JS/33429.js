const ws = new WebSocket('ws://localhost:8080');\n\nws.onopen = function(event) {\n  console.log('WebSocket is open now.');\n  // Send a task submission message\n  ws.send(JSON.stringify({ task: 'start' }));\n};\n\nws.onmessage = function(event) {\n  const data = JSON.parse(event.data);\n  console.log('Progress:', data.progress);\n  // Update progress bar here\n  document.getElementById('progressBar').value = data.progress;\n};\n\nws.onclose = function(event) {\n  console.log('WebSocket is closed now.');\n};\n\nws.onerror = function(error) {\n  console.error('WebSocket Error:', error);\n};