function getFile(pURL, pFunc) {\n    var xhr = new XMLHttpRequest();\n    xhr.open('GET', pURL, true);\n    xhr.responseType = 'arraybuffer'; // Get the response as an array of bytes\n\n    xhr.onload = function() {\n        if (xhr.status === 200) {\n            var arrayBuffer = xhr.response;\n            var byteArray = new Uint8Array(arrayBuffer);\n            // Use the byteArray as needed\n        }\n    };\n\n    xhr.send();\n}