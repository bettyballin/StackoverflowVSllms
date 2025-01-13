$(document).ready(function() {\n    // Ensure only tabs with specific class are hidden initially\n    $('.tab-content').hide();\n    $('.tab-content.default').show(); // Show default tab content\n\n    $('.tabs a').click(function(event) {\n        event.preventDefault();\n        var target = $(this).attr('href');\n\n        $('.tab-content').hide(); // Hide all tab contents\n        $(target).show(); // Show the target tab content\n    });\n});