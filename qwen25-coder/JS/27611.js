$(document).ready(function() {\n    $('#obal form').submit(function(event) { \n        // Initialize errorCount outside the loop\n        var errorCount = 0;\n\n        // Loop through all required fields\n        $('.required').each(function() {\n            if ($(this).val().trim() === "") { // Use trim to avoid spaces-only entries\n                ++errorCount;\n            }\n        });\n\n        // Check error count and prevent form submission on errors\n        if (errorCount > 0) {\n            event.preventDefault(); // Prevent default action of the submit button\n            window.alert('You did not fill in all required fields.');\n        } else {\n            // Optionally, handle successful validation or form submission here\n        }\n    });\n});