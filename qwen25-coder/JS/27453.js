// Assuming the iframe has an id of 'myIframe'\nvar iframe = document.getElementById('myIframe');\n\n// Ensure the iframe content is fully loaded\niframe.onload = function() {\n    // Call a function in the iframe's content window\n    iframe.contentWindow.myFunctionInIframe();\n};