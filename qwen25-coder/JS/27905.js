$(document).ready(function() {\n    $('li.alpha-init').click(function() {\n        // Get the target id from the data attribute\n        var targetId = $(this).data('target');\n        \n        // Toggle the visibility of the corresponding submenu\n        $(targetId).slideToggle(200);\n    });\n});