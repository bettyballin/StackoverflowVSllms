YUI().use('io-base', 'event-custom', function(Y) {\n    // Create a namespace for our events or use an existing one\n    var eventHandler = new Y.Event.Target();\n\n    // Define custom events for each AJAX success\n    eventHandler.publish('check1Success');\n    eventHandler.publish('check2Success');\n\n    // Function to track if both checks are successful\n    var allChecksCompleted = {\n        check1: false,\n        check2: false,\n\n        checkCompletion: function() {\n            return this.check1 && this.check2;\n        }\n    };\n\n    // Callback for the first AJAX call\n    var handleCheck1Success = function() {\n        console.log('Check 1 successful');\n        allChecksCompleted.check1 = true;\n\n        if (allChecksCompleted.checkCompletion()) {\n            executeFinalAction();\n        }\n\n        eventHandler.fire('check1Success');\n    };\n\n    // Callback for the second AJAX call\n    var handleCheck2Success = function() {\n        console.log('Check 2 successful');\n        allChecksCompleted.check2 = true;\n\n        if (allChecksCompleted.checkCompletion()) {\n            executeFinalAction();\n        }\n\n        eventHandler.fire('check2Success');\n    };\n\n    // Function to execute when both checks are successful\n    var executeFinalAction = function() {\n        console.log('Both checks completed successfully. Taking final action.');\n        // Your logic here\n    };\n\n    // Subscribe to custom events if needed\n    eventHandler.on('check1Success', function(e) {\n        console.log('Received check1Success event');\n    });\n\n    eventHandler.on('check2Success', function(e) {\n        console.log('Received check2Success event');\n    });\n\n    // Make both AJAX calls simultaneously\n    Y.io('/api/check1', {\n        on: { success: handleCheck1Success }\n    });\n\n    Y.io('/api/check2', {\n        on: { success: handleCheck2Success }\n    });\n});