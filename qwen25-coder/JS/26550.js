// Ensure DOM is loaded\nwindow.onload = function() {\n    var swf = document.getElementById("mySwf");\n    \n    // Call a function in the SWF\n    if (swf && typeof swf.mySWFFunction === "function") {\n        swf.mySWFFunction();\n    } else {\n        console.error("Function not available or SWF not loaded properly.");\n    }\n};