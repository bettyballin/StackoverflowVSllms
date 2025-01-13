// Array to hold onload functions\nvar onLoadFunctions = [];\n\n// Function to add new onload functions to the array\nfunction addOnLoadFunction(func) {\n    onLoadFunctions.push(func);\n}\n\n// Assigning a single function to window.onload that iterates through the array\nwindow.onload = function() {\n    for (var i = 0; i < onLoadFunctions.length; i++) {\n        onLoadFunctions[i]();\n    }\n};\n\n// Adding functions to the onLoadFunctions array\naddOnLoadFunction(function() {\n    alert("ha!");\n});\n\n// You can add more functions as needed\naddOnLoadFunction(function() {\n    console.log("Another function!");\n});