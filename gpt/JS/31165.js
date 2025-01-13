// Assuming you have an element with the id 'myElement'\nvar element = document.getElementById('myElement');\n\n// Get all attributes of the element\nvar attributes = element.attributes;\n\n// Iterate through the attributes\nfor (var i = 0; i < attributes.length; i++) {\n    var attribute = attributes[i];\n    console.log(attribute.name + " = " + attribute.value);\n}