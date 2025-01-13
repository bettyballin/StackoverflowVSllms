var check1Success = false;\nvar check2Success = false;\n\n// Fire off both AJAX calls\nY.io('check1', { on: { success: check1Handler } });\nY.io('check2', { on: { success: check2Handler } });\n\n// Define event handlers\nfunction check1Handler() {\n    check1Success = true;\n    Y.fire('check1:succeed');\n}\n\nfunction check2Handler() {\n    check2Success = true;\n    Y.fire('check2:succeed');\n}\n\n// Subscribe to custom events\nY.on('check1:succeed', function() {\n    if (check2Success) {\n        // Both checks succeeded, proceed with success logic\n    }\n});\n\nY.on('check2:succeed', function() {\n    if (check1Success) {\n        // Both checks succeeded, proceed with success logic\n    }\n});