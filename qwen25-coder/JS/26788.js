let jsonpRequestActive = true;\n\nfunction handleJsonpResponse(data) {\n    if (jsonpRequestActive) {\n        // Process data\n    }\n}\n\n// To "cancel" JSONP, simply unset the callback\nfunction cancelJsonp() {\n    jsonpRequestActive = false;\n}