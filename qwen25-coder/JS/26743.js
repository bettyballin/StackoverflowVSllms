// Assume your hidden input has an ID of 'hiddenInput'\nconst targetNode = document.getElementById('hiddenInput');\n\n// Configuration of the observer:\nconst config = { attributes: true, attributeFilter: ['value'] };\n\n// Callback function to execute when mutations are observed\nconst callback = function(mutationsList, observer) {\n    for(let mutation of mutationsList) {\n        if (mutation.type === 'attributes' && mutation.attributeName === 'value') {\n            console.log('Hidden input value changed to:', targetNode.value);\n            // Call your second function here or handle the change\n        }\n    }\n};\n\n// Create an observer instance linked to the callback function\nconst observer = new MutationObserver(callback);\n\n// Start observing the target node for configured mutations\nobserver.observe(targetNode, config);\n\n// Later, you can disconnect the observer when it's no longer needed\n// observer.disconnect();