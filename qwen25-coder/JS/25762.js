function getElementOffsetTop(element) {\n    let offset = 0;\n    while (element && element !== document.body) {\n        offset += element.offsetTop - element.scrollTop + element.clientTop;\n        element = element.offsetParent;\n    }\n    return offset;\n}\n\n// Usage:\nconst cellElement = document.querySelector('table td'); // Select your table cell or any other element\nconst topPosition = getElementOffsetTop(cellElement);\nconsole.log(topPosition);