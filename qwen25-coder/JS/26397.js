$(document).on('mouseenter', '.old_post', function(){\n    $(".post_right_nav", this).show();\n    $(this).css({\n        'background-color': '#E6E6E6'\n    });\n}).on('mouseleave', '.old_post', function(){\n    var cssObj = {\n        'background-color': '',\n        'font-weight': ''\n    }\n    $(this).css(cssObj);\n    $(".post_right_nav", this).hide();\n});