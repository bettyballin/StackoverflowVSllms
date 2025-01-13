var debounceTimeout = 500; // 500ms\nvar debounceTimer;\n\n$('#myForm input').on('input', function() {\n    clearTimeout(debounceTimer);\n    debounceTimer = setTimeout(function() {\n        // Validate the input field\n        var input = $(this);\n        var isValid = validateInput(input);\n        if (!isValid) {\n            // Show error message\n            input.next('.error').text('Invalid input');\n        } else {\n            // Hide error message\n            input.next('.error').text('');\n        }\n    }, debounceTimeout);\n});