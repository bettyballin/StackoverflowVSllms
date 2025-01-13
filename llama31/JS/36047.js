function getLowerLeftCornerCoordinates(element) {\n    const rect = element.getBoundingClientRect();\n    const docElement = document.documentElement;\n    const scrollLeft = window.pageXOffset || docElement.scrollLeft;\n    const scrollTop = window.pageYOffset || docElement.scrollTop;\n\n    const x = rect.left + scrollLeft;\n    const y = rect.bottom + scrollTop;\n\n    return { x, y };\n}\n\n// Example usage:\nconst button = document.getElementById('myButton');\nconst coordinates = getLowerLeftCornerCoordinates(button);\nconsole.log(`Lower left corner coordinates: x=${coordinates.x}, y=${coordinates.y}`);