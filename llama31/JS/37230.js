$("#test1").click(function() {\n    $.get("index.html", function(response) {\n        alert('hi');\n    }, "html");\n});