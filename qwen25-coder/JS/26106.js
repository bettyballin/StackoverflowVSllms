document.addEventListener('DOMContentLoaded', function() {\n    var xhr = new XMLHttpRequest();\n    xhr.open('GET', '/email/script/endpoint', true); // Modify this path accordingly\n\n    xhr.onload = function() {\n        if (xhr.status >= 200 && xhr.status < 300) {\n            console.log("Script loaded successfully on homepage:", xhr.responseText);\n        } else {\n            console.error("Failed to load script on homepage. Status: ", xhr.status, "Response Text:", xhr.statusText);\n        }\n    };\n\n    xhr.onerror = function() {\n        console.error("Error loading script on homepage");\n    };\n\n    xhr.send();\n});