function start() {\n    $(".start").click(function () {\n\n        $.post("load_script.php", { }, function(data){\n                alert(data);\n        }, "text");\n\n        return false;\n    });\n}