const userInput = document.getElementById('userInput').value;\n\n// Sanitize user input\nconst sanitizedInput = userInput.replace(/[^a-zA-Z0-9]/g, '');\n\n// Use the sanitized input\nconsole.log(sanitizedInput);