var serviceUrl = "http://myservicedomain";\n    var payload = "<myRequest><content>Some content</content></myRequest>";\n    var request = new XMLHttpRequest();\n    request.open("POST", serviceUrl, true); // <-- This fails in Mozilla Firefox amongst other browsers\n    request.setRequestHeader("Content-type", "text/xml");\n    request.send(payload);