$(document).ready(function() {\n  $('#isAgeSelected').change(function() {\n    if ($(this).prop('checked')) {\n      $("#txtAge").show();\n    } else {\n      $("#txtAge").hide();\n    }\n  });\n});