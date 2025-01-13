function getXY(element) {\n    var x = 0, y = 0;\n    \n    // Calculate element position within the iFrame (or top-level document)\n    while (element) {\n        x += element.offsetLeft;\n        y += element.offsetTop;\n        element = element.offsetParent;\n    }\n\n    // If the element is inside an iFrame, add the iFrame's position\n    var frame = window.frameElement;\n    while (frame) {\n        x += frame.offsetLeft;\n        y += frame.offsetTop;\n        frame = frame.offsetParent;\n    }\n\n    return { x: x, y: y };\n}