$(document).ready(function(){\n    $('.item_roll').mouseover(function() {\n        var dbId = $(this).data('id'); // Get the database ID from the data attribute\n        var $tooltip = $('<div class="tooltip">Loading...</div>').appendTo('body');\n\n        // Make an AJAX call to fetch the content\n        $.ajax({\n            url: 'your-api-endpoint', // Replace with your actual API endpoint\n            type: 'GET',\n            data: { id: dbId },\n            success: function(response) {\n                // Assuming the response contains the content to be shown in the tooltip\n                $tooltip.html(response);\n            },\n            error: function() {\n                $tooltip.html('Error loading content');\n            }\n        });\n\n        // Position and show the tooltip\n        $(this).mousemove(function(event) {\n            $tooltip.css({\n                top: event.pageY + 10 + 'px',\n                left: event.pageX + 10 + 'px'\n            });\n        });\n    }).mouseout(function() {\n        // Remove the tooltip when mouse leaves the image\n        $('.tooltip').remove();\n    });\n});