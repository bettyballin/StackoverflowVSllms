function onValidationFailure() {\n    // Your existing validation failure handling code...\n\n    // Force a reflow to make UI responsive\n    setTimeout(function() {\n        window.resizeBy(1, 1);\n        window.resizeBy(-1, -1);\n    }, 0);\n}