$(document).ready(function() {\n    // Add custom validation methods if needed\n    $.validator.addMethod('phone', function(value, el, params) {\n        return this.optional(el) || /^[0-9,+,(), ,]{1,}(,[0-9]+){0,}$/.test(value);\n    }, 'Please enter a valid phone number');\n\n    // More custom methods...\n\n    $("#form1").validate({\n        // Your validation rules\n        rules: {\n            txt_name: {\n                required: true,\n                minlength: 2\n            },\n            // Other rules...\n        },\n        messages: {\n            txt_name: {\n                required: "This field is required",\n                minlength: "Please enter at least 2 characters"\n            },\n            // Other messages...\n        },\n        submitHandler: function(form) {\n            form.submit(); // Ensure the form is submitted if validation passes\n        }\n    });\n});\n\nfunction validateForm() {\n    // Trigger validation\n    return $("#form1").valid();\n}