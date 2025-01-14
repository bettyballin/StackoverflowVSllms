$(document).ready(function () {\n    // Attach a click event handler to the form submission button (if applicable)\n    $('input[type="submit"]').click(function (e) {\n        var isValid = Page_ClientValidate();\n        if (!isValid) {\n            // If validation fails, add 'formError' class to parent divs\n            $('.errorMessage').closest('div.formLine').addClass('formError');\n        } else {\n            // If validation succeeds, remove 'formError' class from all formLines\n            $('.formLine').removeClass('formError');\n        }\n    });\n\n    // Alternatively, if you want to handle the event after validation (e.g., in a custom validator), you can do:\n    function validateForm() {\n        var isValid = Page_ClientValidate();\n        if (!isValid) {\n            $('.errorMessage').closest('div.formLine').addClass('formError');\n        } else {\n            $('.formLine').removeClass('formError');\n        }\n        return isValid; // Return false to stop form submission in case of errors\n    }\n\n    // Attach your custom validation function to the form onsubmit event or any other trigger you need\n});