OpenURLfromLocation = function(response) {\n  var transport = response.transport;\n  var headers = transport.getAllResponseHeaders();\n  var location = headers['Location'];\n  alert(location);\n}