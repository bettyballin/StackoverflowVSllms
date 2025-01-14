var url = '/proxy?url=' + encodeURIComponent('http://www.google.com/search?q=Prototype');\n\nnew Ajax.Request(url, {\n  method: 'get',\n  onSuccess: function(transport) {\n    var notice = $('notice');\n    console.log("Status Code: " + transport.status); // Log the status code\n    console.log("Status Text: " + transport.statusText); // Log the status text\n\n    if (transport.responseText.match(/href="http:\/\/prototypejs.org/))\n      notice.update('Yeah! You are in the Top 10!').setStyle({ background: '#dfd' });\n    else\n      notice.update('Damn! You are beyond #10...').setStyle({ background: '#fdd' });\n\n    // Example of getting a specific header\n    var contentType = transport.getResponseHeader('Content-Type');\n    console.log("Content Type: " + contentType);\n  }\n});