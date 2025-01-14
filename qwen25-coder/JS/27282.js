function getAbsoluteXY(obj) {\n    let curObj = obj;\n    let curLeft = curTop = 0;\n\n    // Traverse through all offset parents\n    while (curObj.offsetParent) {\n        curLeft += curObj.offsetLeft;\n        curTop += curObj.offsetTop;\n        curObj = curObj.offsetParent;\n    }\n\n    // Check if the element is within an iframe and adjust coordinates\n    let win = obj.ownerDocument.defaultView || window;\n    if (win.frameElement) {\n        const frameRect = win.frameElement.getBoundingClientRect();\n        curLeft += frameRect.left;\n        curTop += frameRect.top;\n    }\n\n    return { x: Math.round(curLeft), y: Math.round(curTop) };\n}