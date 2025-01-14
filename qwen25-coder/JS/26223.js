// Example of a simple defribulator using setInterval in JavaScript\n   function keepSessionAlive() {\n       $.ajax({\n           url: '/KeepSessionAlive.aspx', // Ensure this URL is correctly configured\n           type: 'GET',\n           cache: false,\n           success: function(response) {\n               console.log('Session kept alive');\n           },\n           error: function(xhr, status, error) {\n               console.error('Failed to keep session alive:', error);\n           }\n       });\n   }\n\n   setInterval(keepSessionAlive, 10 * 60 * 1000); // Run every 10 minutes