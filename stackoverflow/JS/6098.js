$(document).ready(function() {\n        $("#lowerLayer").click(function(e) {\n\n            // Return if it's a child that's clicked:\n            if (e.target !== this) {return;}\n\n            // Otherwise continue:\n            $(this).fadeTo("fast", 0, function() {\n                $(this).hide(0);\n            });\n\n        });\n    });\n});