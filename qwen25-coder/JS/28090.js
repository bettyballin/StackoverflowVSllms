// Create a timestamp or random number to invalidate cache\nvar timestamp:Number = new Date().getTime();\n\n// Append this as a parameter to the URL\nhttp.url = "test.xml?time=" + timestamp;\n\n// Make sure that your HttpService is configured properly to send a GET request\nhttp.method = URLRequestMethod.GET;