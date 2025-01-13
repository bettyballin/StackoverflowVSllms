function insertHtmlIntoHead(htmlStr) {\n    // Create a DOM parser\n    var parser = new DOMParser();\n    // Parse the HTML string\n    var doc = parser.parseFromString(htmlStr, 'text/html');\n    // Get all elements from the parsed document's head\n    var elements = doc.head.childNodes;\n    // Append these elements to the current document's head\n    var head = document.getElementsByTagName("head")[0];\n    while (elements.length > 0) {\n        head.appendChild(elements[0]);\n    }\n}\n\n// Usage\nvar htmlStr = "<style>body { background-color: #f2f2f2; }</style><script>alert('Script added');</script>";\ninsertHtmlIntoHead(htmlStr);