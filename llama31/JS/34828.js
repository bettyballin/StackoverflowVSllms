$('#searchbox input').bind('keypress', function(e) {\n    if (e.which === 13) { // 13 is the key code for ENTER\n        // Trigger submit\n        $(this).closest('form').submit();\n    }\n});