function sanitizeInput(input) {\n    var element = document.createElement('div');\n    element.innerText = input;\n    return element.innerHTML;\n}\n\n// Usage\nvar userInput = "<script>alert('XSS');</script>";\nvar safeInput = sanitizeInput(userInput);\nconsole.log(safeInput); // &lt;script&gt;alert('XSS');&lt;/script&gt;