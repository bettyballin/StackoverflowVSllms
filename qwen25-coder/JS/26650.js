if ('fetch' in window) {\n       // Use fetch\n       fetch(url)\n           .then(response => response.json())\n           .then(data => console.log(data))\n           .catch(error => console.error('Error:', error));\n   } else {\n       // Fall back to XMLHttpRequest\n       const xhr = new XMLHttpRequest();\n       xhr.open('GET', url, true);\n       xhr.onreadystatechange = function () {\n           if (xhr.readyState === 4 && xhr.status === 200) {\n               console.log(JSON.parse(xhr.responseText));\n           }\n       };\n       xhr.send(null);\n   }