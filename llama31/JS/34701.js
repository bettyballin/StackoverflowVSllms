function test(event){\n    if (event.keyCode == 13) {\n        $("a").addClass("test");\n        window.location.href = $("a.one").attr("href");\n    }\n    else {\n        $("a").removeClass("test");\n    }\n}