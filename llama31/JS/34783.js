$('.block:has(div)').each(function() {\n    $(this).find('div').each(function() {\n        // do something with each item element\n    });\n});