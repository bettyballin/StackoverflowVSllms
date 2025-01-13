var xhr = new XMLHttpRequest();\nxhr.open("POST", "https://example.com/api", true);\nxhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");\n\nxhr.onreadystatechange = function() {\n    if (xhr.readyState == 4) { // DONE\n        if (xhr.status == 200) {\n            console.log("Response received:", xhr.responseText);\n        } else {\n            console.error("Error:", xhr.statusText);\n        }\n    }\n};\n\nxhr.send(JSON.stringify({key: "value"}));