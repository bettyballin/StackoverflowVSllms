// In your AJAX call\n$.ajax({\n    type: 'POST',\n    url: '/your-ajax-url',\n    data: yourData,\n    success: function(response) {\n        if (response.redirect) {\n            window.location.href = response.redirect;\n        } else {\n            // Handle your other AJAX success logic here\n        }\n    }\n});