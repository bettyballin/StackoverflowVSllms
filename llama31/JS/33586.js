// Client-side JavaScript\nvar xhr = new XMLHttpRequest();\nxhr.open('GET', 'https://example.com/api/data', true);\nxhr.onload = function() {\n  // Handle data\n};\nxhr.send();