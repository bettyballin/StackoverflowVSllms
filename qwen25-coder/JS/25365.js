var xhr = new XMLHttpRequest();\nxhr.open("DELETE", "/user/someone", true);\nxhr.setRequestHeader("Content-Type", "application/json");\nxhr.onreadystatechange = function () {\n    if (xhr.readyState === 4 && xhr.status === 200) {\n        console.log('Success:', xhr.responseText);\n    } else if (xhr.readyState === 4) {\n        console.error('Error:', xhr.statusText);\n    }\n};\nxhr.send();