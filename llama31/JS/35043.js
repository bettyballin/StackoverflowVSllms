$(document).ready(function() {\n  $('#userinput').on('keyup', function() {\n    $('#inputval').text($(this).val());\n  });\n});