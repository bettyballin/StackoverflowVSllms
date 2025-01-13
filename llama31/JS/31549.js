$('#myForm input').on('keyup', function() {\n    // Validate the input field\n    var input = $(this);\n    var isValid = validateInput(input);\n    if (!isValid) {\n        // Show error message\n        input.next('.error').text('Invalid input');\n    } else {\n        // Hide error message\n        input.next('.error').text('');\n    }\n});\n\nfunction validateInput(input) {\n    // Your validation logic here\n    // Return true if the input is valid, false otherwise\n}