$.ajax({\n  url: 'next-page-url',\n  success: function(html) {\n    const nextPageElement = $('<div>').html(html).hide();\n    $('body').append(nextPageElement);\n    nextPageElement.load(function() {\n      $('.current-page').remove();\n      nextPageElement.show();\n    });\n  }\n});