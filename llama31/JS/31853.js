$(document).ready(function() {\n    $('#webdev').hide();\n    $("#apply-webdev").click(function() {\n        $("#webdev").slideToggle();\n        $("#webdev").load("api.php?do=get_form_webdev");\n    });\n});