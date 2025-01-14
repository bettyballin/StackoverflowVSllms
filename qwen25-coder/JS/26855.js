$(document).ready(function() {\n    $('#create_listing_1').submit(function(event) {\n        event.preventDefault(); // Prevent the default form submission\n\n        var formData = $(this).serialize();\n        console.log(formData); // Output to check if it's serialized correctly\n\n        $.ajax({\n            type: 'POST',\n            url: '/your-url-endpoint', // Replace with your URL\n            data: formData,\n            success: function(response) {\n                console.log('Success:', response);\n            },\n            error: function(xhr, status, error) {\n                console.error('Error:', error);\n            }\n        });\n    });\n});