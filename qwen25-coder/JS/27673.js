var xhr = new XMLHttpRequest();\nxhr.open('GET', 'https://api.example.com/resource', true);\nxhr.setRequestHeader('Accept', 'application/json');\nxhr.onload = function () {\n    if (this.status === 200) {\n        console.log(this.responseText);\n    }\n};\nxhr.send();