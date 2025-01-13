// autogrow plugin fix for IE, Safari, Opera and Chrome\n$.fn.autogrow = function() {\n    return this.each(function() {\n        var textarea = $(this);\n        var original_height = textarea.height();\n\n        textarea.css('height', original_height + 'px');\n        textarea.css('overflow-y', 'hidden');\n\n        textarea.keyup(function() {\n            var new_height = $(this).prop('scrollHeight');\n            $(this).css('height', new_height + 'px');\n        });\n    });\n};