$('.timeboxme').blur(function() {\n    var $el = $(this);\n    var theDate = Date.parse($el.val());\n    if(theDate) {\n        $el.val(theDate.toString("HH:mm"));\n    } else {\n        //it didn't appear to be a valid date/time, tell the user\n    }\n});