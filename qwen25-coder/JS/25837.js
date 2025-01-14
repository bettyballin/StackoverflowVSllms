$(document).ready(function() {\n    $('form input').on('input', function() {\n        // Call your validation function here\n        validateField(this);\n    });\n\n    function validateField(element) {\n        var value = $(element).val();\n        // Implement your validation logic here\n        if (value.length < 5) {\n            $(element).next('.error-message').text('This field must be at least 5 characters long.').show();\n        } else {\n            $(element).next('.error-message').hide();\n        }\n    }\n});