// Establish a WebSocket connection\nvar socket = new WebSocket('ws://example.com/ws');\n\n// When the user signs out or times out, send a message to all connected windows\nsocket.onmessage = function(event) {\n  if (event.data === 'closeAllWindows') {\n    closeAllWindows();\n  }\n};\n\n// When a new window is opened, establish a new WebSocket connection\nfunction openNewWindow(url) {\n  var newWindow = window.open(url);\n  var newSocket = new WebSocket('ws://example.com/ws');\n  newSocket.onmessage = function(event) {\n    if (event.data === 'closeAllWindows') {\n      newWindow.close();\n    }\n  };\n}