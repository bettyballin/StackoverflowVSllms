var xhr = new XMLHttpRequest();\nxhr.open("POST", "YourPage.aspx/YourMethod", true);\nxhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");\nxhr.send(JSON.stringify({ name: "John" }));\nxhr.onreadystatechange = function () {\n    if (xhr.readyState === 4 && xhr.status === 200) {\n        // Process the response\n    }\n};