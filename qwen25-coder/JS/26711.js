if(!$.browser.msie) {\n    points = $("div.point");\n} else {\n    points = $("div.flash");\n}\n\n$(points).hover(\n    function () {\n        var point = $(this); // Capture $(this) in a variable\n        $('#features_key').fadeOut('normal', function () {\n            // Use the captured variable here\n            $('#features_key').html(point.next('.info').clone()).fadeIn('normal');\n        });\n    },\n    function () {\n        // Optionally handle mouse leave event here\n    }\n);