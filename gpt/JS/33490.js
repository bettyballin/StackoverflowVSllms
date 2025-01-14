$(document).ready(function() {\n    let isProcessing = false;\n\n    $(window).scroll(function() {\n        if (isProcessing) {\n            return;\n        }\n\n        isProcessing = true;\n\n        // Your function logic here\n        setTimeout(function() {\n            // Simulate the function taking time to execute\n            console.log('Function executed');\n            \n            // Reset the flag after the function has finished executing\n            isProcessing = false;\n        }, 1000); // Adjust the timeout as needed\n    });\n});