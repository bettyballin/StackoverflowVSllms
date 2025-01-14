(function($) {\n\n    $.extend({\n        \n        pingKeepAlive: function(interval) {\n            interval = interval || 60000; // 1 minute by default\n\n            setInterval(function() {\n                $.ajax({\n                    type: 'GET',\n                    url: '/Auth/KeepAlive', // Update the URL accordingly\n                    timeout: 2000, // Timeout after 2 seconds\n                    success: function(data) {\n                        console.log('Session renewed!');\n                    },\n                    error: function(err) {\n                        console.error('Failed to renew session:', err);\n                    }\n                });\n            }, interval);\n        }\n\n    });\n\n})(jQuery);\n\n// Usage:\n$(document).ready(function() {\n    $.pingKeepAlive(60000); // Ping every minute\n});