function Request(url, callback) {\n    var httpRequest;\n    if (window.XMLHttpRequest) { // Mozilla, Safari, ...\n        httpRequest = new XMLHttpRequest();\n    } else if (window.ActiveXObject) { // IE\n        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");\n    } else {\n        return false;\n    }\n\n    httpRequest.onreadystatechange = function () {\n        console.log('readyState: ' + httpRequest.readyState);\n        if (httpRequest.readyState === 4) {\n            if (httpRequest.status === 200) {\n                callback(httpRequest.responseText);\n            } else {\n                console.error('Error in request. Status: ' + httpRequest.status);\n            }\n        }\n    };\n\n    try {\n        httpRequest.open('GET', url, true);\n        httpRequest.send(null);\n    } catch (e) {\n        console.error('An error occurred while sending the request: ' + e.message);\n    }\n}