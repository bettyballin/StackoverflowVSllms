$("td").each(function()\n{\n    $(this).mouseover(function()\n    {\n        tip($(this).children("span").attr("title"));\n    });\n});