$("select").change(function(){\n    var formData = $(this).closest('form').serialize();\n    $.get("page.html", formData);\n});