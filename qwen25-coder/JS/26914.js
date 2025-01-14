function setMeFixed() {\n    // Create a new div element to replace the marquee\n    var fixedElement = document.createElement('div');\n    // Find the first (and only) marquee element in the document\n    var marqueeElement = document.getElementsByTagName('marquee')[0];\n    \n    // Iterate through each child node of the marquee element\n    for (var i = 0; i < marqueeElement.childNodes.length; i++) {\n        var node = marqueeElement.childNodes[i];\n        // Check if the node is an Element Node\n        if (node.nodeType === Node.ELEMENT_NODE) {\n            fixedElement.appendChild(node);\n        }\n    }\n\n    // Replace the old marquee element with the new div element in the DOM\n    marqueeElement.parentNode.replaceChild(fixedElement, marqueeElement);\n}