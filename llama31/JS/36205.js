var xhr = new XMLHttpRequest();\nxhr.open('GET', '/path/to/resource', true);\nxhr.withCredentials = true; // includes HttpOnly cookies\nxhr.send();