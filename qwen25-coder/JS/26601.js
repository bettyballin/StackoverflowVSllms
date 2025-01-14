// Save a reference to the original Ajax.Request class\nvar OriginalAjaxRequest = Ajax.Request;\n\n// Override Ajax.Request with a new function that wraps the original one\nAjax.Request = function(url, options) {\n    // Check if the onSuccess callback is provided\n    if (options && typeof options.onSuccess === 'function') {\n        var originalOnSuccess = options.onSuccess;\n        \n        // Wrap the original onSuccess in another function\n        options.onSuccess = function(response) {\n            try {\n                // Call your custom function to check the response\n                if (!checkResponse(response)) {\n                    // If the check fails, do not proceed with the original onSuccess\n                    return;\n                }\n                \n                // If it's good, call the original onSuccess function\n                originalOnSuccess(response);\n            } catch (e) {\n                console.error("Error in custom Ajax.Request wrapper:", e);\n            }\n        };\n    }\n\n    // Call the original Ajax.Request constructor with all arguments\n    return new OriginalAjaxRequest(url, options);\n};\n\n// Define your response checking function\nfunction checkResponse(response) {\n    // Add your logic to check the response here\n    console.log("Checking response:", response);\n    return true; // Return false if you want to prevent onSuccess from firing\n}