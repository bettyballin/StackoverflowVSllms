$(document).ready(function() {\n    $('tr').each(function(index) {\n        if (index % 2 === 0) {\n            $(this).addClass('even');\n        } else {\n            $(this).addClass('odd');\n        }\n    });\n});