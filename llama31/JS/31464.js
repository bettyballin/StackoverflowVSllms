// In your Silverlight application, add a JavaScript function to send a keep-alive request\nfunction keepSessionAlive() {\n  var xhr = new XMLHttpRequest();\n  xhr.open('GET', '/KeepAlive.aspx', true); // Create a dummy page on your ASP.NET site\n  xhr.send();\n}\n\n// Call the keep-alive function every 10 minutes (adjust the interval as needed)\nsetInterval(keepSessionAlive, 600000); // 10 minutes