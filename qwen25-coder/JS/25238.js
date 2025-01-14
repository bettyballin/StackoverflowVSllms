$('a', container).live('click', function() {\n    var $container = $(this).parents('.bfcontainer');\n\n    // Determine if this menu item has children (submenus)\n    var hasSubmenu = $(this).data('sub').children('li').length > 0;\n\n    // Remove blocks to the right in the tree, and 'deactivate' other links within the same level\n    $('div:gt(' + $('div', $container).index($(this).parents('div')) + ')', $container).remove();\n    $('div:eq(' + $('div', $container).index($(this).parents('div')) + ') a', $container)\n        .removeClass('active').removeClass('inpath');\n    $('.active', $container).addClass('inpath');\n    $(this).addClass('active');\n\n    if (hasSubmenu) {\n        // Add submenu if this item has children\n        submenu($container, this);\n    } else {\n        // Handle click on an item without submenus (trigger AJAX or other action)\n        var title = $('<a/>').attr({href: $(this).attr('href')}).text($(this).attr('title') ? \n            $(this).attr('title') : $(this).text());\n        var featurebox = $('<div/>').html(title).addClass('feature').appendTo($container);\n\n        // Set width\n        var remainingSpace = 0;\n        $.each($container.children('div').slice(0, -1), function(i, item) {\n            remainingSpace += $(item).width();\n        });\n\n        var fillWidth = $container.width() - remainingSpace;\n\n        featurebox.css({'top': 0, 'left' : remainingSpace}).width(fillWidth).show('slow');\n\n        // Call your AJAX function here or handle the link click as needed\n        // For example:\n        loadContentViaAjax($(this).attr('href'));\n    }\n\n    // Return false only if there are submenus to prevent default action\n    return hasSubmenu;\n});\n\nfunction loadContentViaAjax(url) {\n    // Implement your AJAX call logic here\n    $.ajax({\n        url: url,\n        success: function(data) {\n            $('#content').html(data); // Assuming you have a div with id 'content' to display the loaded content\n        }\n    });\n}