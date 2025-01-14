$(document).ready(function() {\n    $('.menu-item').click(function(e) {\n        e.preventDefault(); // Prevent the default action of the link\n\n        var target = $(this).attr('href'); // Get the target div ID from href attribute\n\n        // Hide all content divs and then show the clicked one\n        $('.content-div').hide();\n        $(target).show();\n    });\n});