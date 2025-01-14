$(document).ready(function() {\n    // Function to parse query strings in the URL.\n    function getParameterByName(name) {\n        var url = window.location.href;\n        name = name.replace(/[\[\]]/g, '\\$&');\n        var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),\n            results = regex.exec(url);\n        if (!results) return null;\n        if (!results[2]) return '';\n        return decodeURIComponent(results[2].replace(/\+/g, ' '));\n    }\n\n    // Check for the specific parameter and trigger the function.\n    var section = getParameterByName('s');\n    if (section === 'products') {\n        showProducts(); // Call your function to display products\n    } else {\n        showHome(); // Default to home or whatever other default action\n    }\n});\n\nfunction showProducts() {\n    // Your code to show the products section here\n    console.log("Showing products");\n}\n\nfunction showHome() {\n    // Your code to show the home section here\n    console.log("Showing home");\n}