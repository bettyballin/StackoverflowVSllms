$("select").change(function(){\n    $.get("/page.html?" + $(this).parent("form").find(":input").serialize()); \n});