var xhr = new XMLHttpRequest();\nxhr.onreadystatechange = function() {\n    console.log("readyState: " + xhr.readyState);\n    if (xhr.readyState === 3) { // LOADING\n        console.log("Data received so far: " + xhr.responseText);\n    } else if (xhr.readyState === 4 && xhr.status === 200) { // DONE and successful\n        console.log("Response complete.");\n    }\n};\nxhr.open('GET', 'your-cgi-url.cgi', true);\nxhr.send();