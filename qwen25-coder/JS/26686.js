setInterval(function() {\n    $.ajax({\n        url: 'your-server-endpoint',\n        success: function(data) {\n            // Update your page with the data here\n        }\n    });\n}, 5000); // Fetch new data every 5 seconds