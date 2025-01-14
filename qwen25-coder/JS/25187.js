function replaceText(elementId, newText) {\n    var element = document.getElementById(elementId);\n    if (element !== null) {\n        // Replace all child nodes with a new text node\n        element.textContent = newText;\n    }\n}\n\n// Usage:\nreplaceText('myElementId', 'This is the new text.');