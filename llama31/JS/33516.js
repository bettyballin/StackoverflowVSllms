var xhr = new XMLHttpRequest();\nxhr.onreadystatechange = function() {\n  if (xhr.readyState == 4 && xhr.status == 200) {\n    // Process the response from the server\n    var response = xhr.responseText;\n    // Update the page content here\n  }\n};\nxhr.open('GET', '/comet-endpoint', true);\nxhr.send();