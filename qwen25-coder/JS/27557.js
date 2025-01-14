// Function to reset file input field\nfunction resetFileInput(fieldId) {\n    var fileInput = document.getElementById(fieldId);\n    if (fileInput) {\n        // Create a new file input element\n        var newFileInput = document.createElement('input');\n        newFileInput.type = 'file';\n        newFileInput.id = fieldId;\n        newFileInput.name = fileInput.name;\n\n        // Copy data attributes and classes from the old to the new input\n        for (var attr of fileInput.attributes) {\n            if (attr.name !== "id" && attr.name !== "type") {\n                newFileInput.setAttribute(attr.name, attr.value);\n            }\n        }\n\n        // Replace the old file input with the new one\n        fileInput.parentNode.replaceChild(newFileInput, fileInput);\n    }\n}\n\n// Event listeners for resetting the file inputs based on your example\ndocument.getElementById('select-file').addEventListener('focus', function() {\n    resetFileInput('upload-file');\n});\n\ndocument.getElementById('upload-file').addEventListener('focus', function() {\n    resetFileInput('select-file');\n});