$(document).ready(function() {\n\n\n    $("img.thumbImg").mouseover(function() {\n    $(this).attr("height", "100").attr("width", "100");\n    }).mouseout(function() {\n    $(this).attr("height", "50").attr("width", "50");\n    })\n\n});