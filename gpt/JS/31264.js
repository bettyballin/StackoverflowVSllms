$(document).ready(function() {\n    $('#yourTableId').on('click', 'td', function() {\n        $(this).css('background-color', 'yourColor');\n    });\n});