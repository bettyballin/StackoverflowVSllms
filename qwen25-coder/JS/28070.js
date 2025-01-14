$(document).ready(function() {\n    setInterval(function() {\n        $.ajax({\n            type: "POST",\n            url: "YourHandler.ashx", // Replace with your handler's path\n            data: { id: 123 }, // Assuming 'id' is the variable you want to send\n            success: function(response) {\n                console.log('Server responded:', response);\n            },\n            error: function(xhr, status, error) {\n                console.error('An error occurred:', status, error);\n            }\n        });\n    }, 60000); // Call every minute (60000 milliseconds)\n});