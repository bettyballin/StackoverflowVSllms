function start() {\n    $(".start").click(function () {\n\n        $.post("load_script.php", {}, function(data){\n            if (data.error) {\n                alert('Error: ' + data.error);\n            } else {\n                alert(data[247][0]);\n            }\n        }, "json");\n\n        return false;\n    });\n}