$(document).ready(function () {\n    var $links = $('#nav ul li a');\n    $links.click(function() {\n        $links.css("color","white");\n        $(this).css("color","yellow");\n        $("#content").load("files/" + $(this).attr('id') + ".html");       \n    });\n});