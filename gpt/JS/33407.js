function ajaxFunction() {\n    return new Promise(function(resolve, reject) {\n        var ajaxRequest = new XMLHttpRequest();\n        ajaxRequest.onreadystatechange = function () {\n            if (ajaxRequest.readyState == 4) {\n                if (ajaxRequest.status == 200) {\n                    // Success code\n                    var MyVariable = 'MyContent';\n                    resolve(MyVariable);  // Resolve the promise with the variable\n                } else {\n                    reject('Error: ' + ajaxRequest.statusText);\n                }\n            }\n        };\n        // Sending the request (replace 'your-url' with the actual URL)\n        ajaxRequest.open('GET', 'your-url', true);\n        ajaxRequest.send();\n    });\n}\n\nfunction popup() {\n    ajaxFunction().then(function(MyVariable) {\n        alert(MyVariable);\n    }).catch(function(error) {\n        console.error(error);\n    });\n}