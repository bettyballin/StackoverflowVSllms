function getOffsetTop(element) {\n    let offsetTop = 0;\n    while (element) {\n        offsetTop += element.offsetTop;\n        element = element.offsetParent;\n    }\n    return offsetTop;\n}\n\n// Example usage:\nconst tableElement = document.querySelector('table tr td'); // Select your specific table element\nconst offset = getOffsetTop(tableElement);\nconsole.log('Offset top:', offset);