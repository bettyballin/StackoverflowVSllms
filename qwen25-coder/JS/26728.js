// This will list available cipher suites supported by the current browser.\nfunction logSupportedCipherSuites() {\n    var connection = new WebSocket('wss://www.howsmyssl.com/a/check');\n    \n    connection.onopen = function() {\n        console.log("Connection opened");\n    };\n\n    connection.onerror = function(error) {\n        console.error("Error connecting to howsmyssl:", error);\n    };\n\n    connection.onmessage = function(event) {\n        var data = JSON.parse(event.data);\n        console.log('Supported Cipher Suites:', data.tls_version, data.cipher);\n        connection.close();\n    };\n}