// Select the element\nvar element = document.querySelector('div');\n\n// Get all attributes from the element\nvar attributes = element.attributes;\n\n// Iterate over each attribute\nfor (var i = 0; i < attributes.length; i++) {\n    // Get name and value of attribute\n    var attrName = attributes[i].name;\n    var attrValue = attributes[i].value;\n    \n    console.log(attrName + '="' + attrValue + '"');\n}