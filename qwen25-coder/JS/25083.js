function makeRequest(url) {\n    var xhr = new XMLHttpRequest();\n    xhr.onreadystatechange = function() {\n        if (xhr.readyState === 4 && xhr.status === 200) {\n            console.log('Response received:', xhr.responseText);\n        }\n    };\n    xhr.open("POST", url, true);\n    xhr.send(null);\n}\n\n// Different requests from same page\nmakeRequest('/api/data1');\nmakeRequest('/api/data2');