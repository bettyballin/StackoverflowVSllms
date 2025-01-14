var myCallBackExample = {\n    myFirstFunction: function(param1, param2, callback) {\n        // Do something with param1 and param2.\n        console.log("Using parameters:", param1, param2);\n\n        if (arguments.length == 3 && typeof callback === 'function') {\n            // Execute the callback function.\n            callback();\n        }\n    },\n    mySecondFunction: function() {\n        this.myFirstFunction(false, true, function() {\n            // This anonymous function will be executed once myFirstFunction is done.\n            console.log("Callback has been executed.");\n        });\n    }\n};\n\n// To see it in action\nmyCallBackExample.mySecondFunction();