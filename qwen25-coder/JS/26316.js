$(window).on('load', function() {\n    $('.entries').each(function(r) {    \n        $(this).attr("value", $(this).outerHeight()+15);\n    });\n});