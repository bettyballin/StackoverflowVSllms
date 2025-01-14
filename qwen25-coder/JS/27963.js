function pull() {\n    var myLoader = new air.URLLoader();\n    var myRequest = new air.URLRequest('http://something/something.xml');\n    myLoader.addEventListener(air.Event.COMPLETE, pulled);\n    myLoader.load(myRequest);\n}\n\nfunction pulled(evt) {\n    if (evt.target.bytesTotal > 0) {\n        // Properly encode the XML content\n        var encodedXML = encodeURIComponent(evt.target.data);\n\n        var myLoader = new air.URLLoader();\n        var myRequest = new air.URLRequest('http://someplace/push.php');\n        myRequest.method = air.URLRequestMethod.POST;\n        \n        // Set the URL-encoded string as data, ensuring 'xml' is the parameter name\n        myRequest.data = "xml=" + encodedXML;\n\n        // Optionally set headers if your server expects specific format\n        var headers = new air.ArrayCollection();\n        headers.addItem(new air.URLRequestHeader("Content-Type", "application/x-www-form-urlencoded"));\n        myRequest.requestHeaders = headers;\n\n        myLoader.dataFormat = air.URLLoaderDataFormat.TEXT;\n        myLoader.addEventListener(air.Event.COMPLETE, pushed);\n        myLoader.load(myRequest);\n    }\n}\n\nfunction pushed(evt) {\n    // Handle the response from the server\n    console.log("Server Response: " + evt.target.data);\n}