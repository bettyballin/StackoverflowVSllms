$.ajax({\n    url: '/your-controller/your-ajax-function',\n    type: 'POST',\n    data: {\n        // Your data here\n    },\n    success: function(response) {\n        if (response.redirect) {\n            window.location.href = response.redirect;\n        } else {\n            // Handle your usual response data\n            console.log(response.data);\n        }\n    },\n    error: function(xhr, status, error) {\n        // Handle error\n        console.error(error);\n    }\n});