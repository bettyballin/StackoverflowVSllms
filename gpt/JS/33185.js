setInterval(function() {\n    $.ajax({\n        url: '/check-for-new-answers',\n        method: 'GET',\n        success: function(response) {\n            if (response.newAnswers) {\n                alert(response.newAnswers + " new answers have been posted, load new answers");\n                // You can also update the UI dynamically here\n            }\n        }\n    });\n}, 5000); // Poll every 5 seconds