function getElementAtPosition(x, y) {\n    return document.elementFromPoint(x, y);\n}\n\n// Example usage:\nconst element = getElementAtPosition(100, 200);\nconsole.log(element.tagName); // Outputs the tag name of the element