$(document).ready(function() {\n    $("span").click(function() {\n        $(this).animate({\n            backgroundColor: "#FFFF99"\n        }, "slow", function() {\n            // Animation complete.\n        });\n    });\n});