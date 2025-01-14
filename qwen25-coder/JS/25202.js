$(document).ready(function() {\n    $(".productSelectInput").each(function() {\n        var maxLength = 0;\n        $(this).find("option").each(function() {\n            var len = $(this).text().length;\n            if (len > maxLength) {\n                maxLength = len;\n            }\n        });\n        // Approximate pixel width for each character\n        var approxWidthPerChar = 8; \n        var totalWidth = (maxLength * approxWidthPerChar) + 20; // Add some extra pixels for padding/border\n\n        $(this).css("width", totalWidth + "px");\n    });\n});