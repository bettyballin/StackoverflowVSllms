// Function to upload files using AJAX\nfunction uploadFile(file) {\n    var xhr = new XMLHttpRequest();\n    var formData = new FormData();\n\n    // Append the file to the form data\n    formData.append('file', file);\n\n    // Set up the request\n    xhr.open('POST', '/upload', true);\n\n    // Define what happens on successful data submission\n    xhr.onload = function () {\n        if (xhr.status === 200) {\n            console.log('File uploaded successfully');\n        } else {\n            console.error('Error uploading file: ' + xhr.responseText);\n        }\n    };\n\n    // Send the request with form data\n    xhr.send(formData);\n}\n\n// Example usage:\ndocument.getElementById('fileInput').addEventListener('change', function(e) {\n    var file = e.target.files[0];\n    if (file) {\n        uploadFile(file);\n    } else {\n        console.error('No file selected');\n    }\n});