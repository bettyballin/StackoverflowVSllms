$(function() {\n    $(document).on('click', '.viewPage', function() {\n        $('#mainarticle').fadeOut('slow');\n        $.get($(this).attr('href'), { js: "1" }, function(data) {\n            $('#mainarticle').html(data).fadeIn('slow');\n        });\n        return false;\n    });\n});