$('#myForm').submit(function() {\n    $(this).ajaxSubmit(function (data) {\n         if (data==1){\n             $('#bad').fadeIn("slow");\n         }\n    });\n\n    return false;\n});