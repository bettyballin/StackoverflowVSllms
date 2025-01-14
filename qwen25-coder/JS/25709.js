var xhr = new XMLHttpRequest();\nxhr.onreadystatechange = function() {\n    if (this.readyState === XMLHttpRequest.DONE) {\n        if (this.status === 0) {\n            console.log("The request was aborted.");\n        } else {\n            console.log("Request completed with status: " + this.status);\n        }\n    }\n};\n\nxhr.open('GET', 'your-url-here', true);\n\n// Simulate an abort condition\nsetTimeout(function() {\n    xhr.abort();\n}, 1000); // abort after 1 second