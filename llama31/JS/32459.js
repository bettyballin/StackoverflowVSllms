$(document).ready(function () {\n    $('#productList li a').click(function () {\n        $('#productList li').removeClass('active');\n        $(this).parent('li').addClass('active');\n    });\n});