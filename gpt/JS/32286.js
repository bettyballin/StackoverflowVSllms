$(document).ready(function() {\n    $("li").click(function() {\n        var current_id = $(this).attr('id');\n        if (/^outer\d+m$/.test(current_id)) {\n            alert(current_id);\n        }\n    });\n});