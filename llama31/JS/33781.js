// ...\n\nvar selector = $(this);\n\n// ...\n\n$(".pageNav a").live("click", function(event) {\n    // ...\n    $(selector).hide();\n    $(selector + ".page" + clickedLink).show();\n    return false;\n});