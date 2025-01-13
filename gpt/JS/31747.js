function isElementProperlyClosed(htmlString, tagName) {\n    const parser = new DOMParser();\n    const doc = parser.parseFromString(htmlString, 'text/html');\n    const elements = doc.getElementsByTagName(tagName);\n\n    // Check if the number of opening tags matches the number of closing tags\n    return elements.length > 0 && elements.length === doc.documentElement.getElementsByTagName(tagName).length;\n}\n\nconst htmlString = '<div><p>Test</p></div>'; // Example HTML string\nconst tagName = 'p'; // Tag name to check\n\nif (isElementProperlyClosed(htmlString, tagName)) {\n    console.log('The element is properly closed.');\n} else {\n    console.log('The element is not properly closed.');\n}