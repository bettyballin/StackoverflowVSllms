let rowIndex = 0;\nconst formElements = document.querySelectorAll('.form-row'); // Adjust selector as needed\n\nfunction sendRequest() {\n    if (rowIndex >= formElements.length) return;\n\n    const formData = new FormData(formElements[rowIndex]);\n    const queryString = new URLSearchParams(formData).toString();\n\n    request5 = new XMLHttpRequest();\n    request5.onreadystatechange = function() {\n        if (request5.readyState === 4 && request5.status === 200) {\n            document.getElementById(displayElem + rowIndex).innerHTML = request5.responseText;\n            rowIndex++;\n            sendRequest(); // Send the next request\n        }\n    };\n    request5.open('GET', `your-php-script.php?${queryString}`, true);\n    request5.send();\n}\n\n// Initialize the first request\nsendRequest();