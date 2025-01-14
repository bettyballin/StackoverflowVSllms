// Assume we have a global variable that we want to set\nvar myGlobalVariable = true;\n\nfunction hideElements() {\n    // Logic to hide elements\n    console.log('Hiding elements...');\n}\n\nfunction setGlobalVariable() {\n    myGlobalVariable = false;\n    console.log('Global variable set to false');\n}\n\n// Get the select element\nvar selectBox = document.getElementById("selectbox1");\n\nif (<certain conditions>) {\n    // Store the existing event handler, if any\n    var existingHandler = selectBox.onchange;\n\n    // Set a new function that will call both the old and the new functions\n    selectBox.onchange = function() {\n        if (existingHandler) {\n            existingHandler.call(this);  // Call the original function if it exists\n        }\n        hideElements();  // Call your hide elements function\n    };\n}\n\nif (<other conditions>) {\n    var existingHandler = selectBox.onchange;\n\n    selectBox.onchange = function() {\n        if (existingHandler) {\n            existingHandler.call(this);  // Ensure the previous functionality is preserved\n        }\n        setGlobalVariable();  // Call your new function to set the global variable\n    };\n}