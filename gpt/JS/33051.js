<script>\n    function enqueueUser(userId) {\n        $.ajax({\n            url: '/api/queue/enqueue',\n            type: 'POST',\n            contentType: 'application/json',\n            data: JSON.stringify(userId),\n            success: function (data) {\n                alert('Your position in the queue is: ' + data.position);\n                checkPosition(userId);\n            }\n        });\n    }\n\n    function checkPosition(userId) {\n        setInterval(function () {\n            $.ajax({\n                url: `/api/queue/position/${userId}`,\n                type: 'GET',\n                success: function (data) {\n                    if (data.position === 1) {\n                        alert('It\'s your turn!');\n                        // Additional logic to enable robot control for the user\n                    }\n                }\n            });\n        }, 5000);  // Check every 5 seconds\n    }\n</script>