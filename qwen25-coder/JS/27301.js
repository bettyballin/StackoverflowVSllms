function countLinesInElement(elementId) {\n    var el = document.getElementById(elementId);\n    if (!el) return 0;\n\n    // Get the height and line-height of the element\n    var clientHeight = el.clientHeight,\n        lineHeightString = window.getComputedStyle(el, null).getPropertyValue("line-height"),\n        lineHeight = parseFloat(lineHeightString);\n\n    // If lineHeight is not set or 'normal', assume a default value\n    if (isNaN(lineHeight) || lineHeight === 0 || lineHeightString === 'normal') {\n        lineHeight = parseFloat(window.getComputedStyle(el, null).getPropertyValue("font-size")) * 1.2; // A typical multiplier for normal line-height\n    }\n\n    // Calculate number of lines\n    var numberOfLines = clientHeight / lineHeight;\n\n    return Math.round(numberOfLines);\n}\n\n// Usage:\nvar linesCount = countLinesInElement('content');\nconsole.log('Number of lines:', linesCount);