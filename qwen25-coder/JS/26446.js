$(document).ready(function() {\n    // Add hints before each input field\n    $('form#myForm input').each(function(){\n        var hintText = $(this).attr('data-hint');\n        if (hintText) {\n            $('<div class="hint">' + hintText + '</div>').insertBefore(this);\n        }\n    });\n\n    // Validate the form\n    $("#myForm").validate({\n        rules: {\n            name: "required",\n            email: {\n                required: true,\n                email: true\n            }\n        },\n        messages: {\n            name: "Please enter your name",\n            email: {\n                required: "Please enter a valid email address",\n                email: "Email must be in the format of name@domain.com"\n            }\n        },\n        errorPlacement: function(error, element) {\n            error.insertAfter(element.siblings('.hint'));\n        },\n        highlight: function(element) {\n            $(element).closest('.hint').addClass('error');\n        },\n        unhighlight: function(element) {\n            $(element).closest('.hint').removeClass('error');\n        }\n    });\n});