$(document).ajaxSuccess(function(event, xhr, settings) {\n    // Your custom function to be called on AJAX success\n    myCustomFunction();\n\n    function myCustomFunction() {\n        console.log("AJAX call succeeded!");\n        // Your custom logic here\n    }\n});