function hideElementById(elementId) {\n    var element = document.getElementById(elementId);\n    if (element) {\n        element.style.display = 'none';\n    }\n}\n\n// Example usage:\nhideElementById('someElementId');\nhideElementById('anotherElementId');