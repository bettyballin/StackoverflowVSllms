$(function() {\n    $.isShiftDown = false;\n    $('input#partName').keydown(function(e) {\n        if (e.keyCode == 16) $.isShiftDown = true;\n        if ($(this).val().length == 0 && (e.keyCode == 188 ||\n            e.keyCode == 189)) return false;\n        return ($.inArray(e.keyCode, [8, 13, 35, 36, 37, 39, 46, 48, 49, 50,\n            51, 52, 53, 54, 55, 56, 57, 188, 189]) > -1 && !$.isShiftDown)\n            || (e.keyCode > 64 && e.keyCode < 91);\n    }).keyup(function(e) { if (e.keyCode == 16) $.isShiftDown = false; });\n});