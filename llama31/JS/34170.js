$.ajax({\n    type: 'POST',\n    url: '/page2.php',\n    data: { email: $('#email').val() },\n    dataType: 'json',\n    success: function(response) {\n        // Stop the animation and show the result\n        stopAnimation();\n        alert(response.message);\n    },\n    error: function(xhr, status, error) {\n        console.error(xhr.responseText);\n    }\n});