function bindEventHandlers() {\n    $('.viewPage').off('click').on('click', function() {\n        $('#mainarticle').fadeOut('slow');\n        $.get($(this).attr('href'), { js: "1" }, function(data) {\n            $('#mainarticle').html(data).fadeIn('slow', function() {\n                bindEventHandlers(); // Re-bind the event handlers after the content is loaded\n            });\n        });\n        return false;\n    });\n}\n\n$(function() {\n    bindEventHandlers(); // Initial binding\n});