$(document).ready(function() {\n    $(".readOnlyRow div").hide();\n    $("#readOnlyRowsToggle").click(function() {\n        $(".readOnlyRow div").toggle();\n    });\n});