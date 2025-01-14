// Example using XMLHttpRequest\nfunction setClientVarWithAjax(varName, varValue) {\n    var xhr = new XMLHttpRequest();\n    xhr.open('POST', 'path_to_your_cfc.cfc?method=setClientVariable&varName=' + encodeURIComponent(varName) + '&varValue=' + encodeURIComponent(varValue), true);\n    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');\n    xhr.onreadystatechange = function () {\n        if (xhr.readyState === 4 && xhr.status === 200) {\n            console.log("Client variable set successfully.");\n        }\n    };\n    xhr.send();\n}\n\n// Example call\nsetClientVarWithAjax('myVar', 'someValue');