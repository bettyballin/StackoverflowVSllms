$("#editor").live('input paste',function(e){\n    if(e.target.id == 'editor') {\n        $('<textarea></textarea>').attr('id', 'paste').appendTo('#editMode');\n        $("#paste").focus();\n        setTimeout($(this).paste, 250);\n    }\n});