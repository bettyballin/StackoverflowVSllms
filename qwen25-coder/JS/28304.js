function sendKeystrokes() {\n    const firstName = document.getElementById('firstNameInput').value;\n    \n    // Create an XMLHttpRequest object\n    const xhr = new XMLHttpRequest();\n    \n    // Configure it\n    xhr.open('POST', 'process_input.php');\n    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\n\n    // Define what happens on successful data submission\n    xhr.onload = function() {\n        if (xhr.status === 200) {\n            document.getElementById('result').innerText = "Received: " + firstName;\n        }\n    };\n\n    // Send the data!\n    xhr.send(`first_name=${encodeURIComponent(firstName)}`);\n}