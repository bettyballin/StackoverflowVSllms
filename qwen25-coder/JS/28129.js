<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>\n<script type="text/javascript">\n$(document).ready(function() {\n    $('a').on('click', function(e) {\n        $(this).off('click'); // Remove click handler to prevent multiple clicks\n        var originalHandler = $(this).data('original-click-handler');\n        if (!originalHandler) {\n            originalHandler = e.handler;\n            $(this).data('original-click-handler', originalHandler);\n        }\n        setTimeout(function() {\n            // Reattach the click event after a delay (e.g., 1 second)\n            $(this).on('click', function(e) { return originalHandler.apply(this, arguments); });\n        }.bind(this), 1000);\n    });\n\n    // Alternatively, disable the link temporarily\n    $('a').once('click', function() {\n        var $link = $(this);\n        $link.data('clicked', true);\n        setTimeout(function() {\n            $link.data('clicked', false);\n        }, 1000); // Reset after a short delay\n    }).on('click', function(e) {\n        if ($(this).data('clicked')) {\n            e.preventDefault(); // Prevent default action if link was already clicked recently\n        }\n    });\n});\n</script>