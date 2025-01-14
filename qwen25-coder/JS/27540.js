function makeRequest(url, parameters) {\n   var http_request = new XMLHttpRequest();\n   if (http_request.overrideMimeType) {\n      http_request.overrideMimeType('text/xml');\n   }\n   if (!http_request) {\n      alert('Cannot create XMLHTTP instance');\n      return false;\n   }\n\n   // Use an anonymous function to capture the current state of http_request\n   http_request.onreadystatechange = function() {\n      alertContents(http_request);\n   };\n\n   http_request.open('GET', url + parameters, true);\n   http_request.send(null);\n}\n\nfunction alertContents(http_request) {\n   if (http_request.readyState == 4) {\n      if (http_request.status == 200) {\n         alert('Found: ' + http_request.responseText);\n      } else {\n         alert('There was a problem with the request.');\n      }\n   }\n}