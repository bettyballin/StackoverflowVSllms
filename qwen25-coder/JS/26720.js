$(function() {\n    var isFirst = true; // Track which function to call\n\n    function first_function() {\n        // First function code goes here\n        console.log("First function called");\n    }\n\n    function second_function() {\n        // Second function code goes here\n        console.log("Second function called");\n    }\n\n    $("#toggleLink").click(function() {\n        if (isFirst) {\n            first_function();\n            isFirst = false;\n        } else {\n            second_function();\n            isFirst = true;\n        }\n    });\n});