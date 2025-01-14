$("#submit").click(function() {\n    var data = {};\n    var playCount = $("#play option:selected").text();\n\n    for (var i = 1; i <= playCount; ++i) {\n        data["play_" + i] = $("#play_" + i).val();\n    }\n\n    $.post("../includes/process.php", data, function(response) {\n        $("#activityWindow").empty().append(response);\n    });\n});