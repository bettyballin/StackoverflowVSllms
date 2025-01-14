$(document).ready(function() {\n    // Sample JSON structure for demonstration\n    var jsonData = [\n        { "content": "First item" },\n        { "content": "Second item" },\n        { "content": "Third item" }\n    ];\n\n    $.each(jsonData, function(index, item) {\n        // Create a new element (e.g., paragraph)\n        var $newElement = $('<p/>').text(item.content).css('display', 'none');\n        \n        // Append it to your container\n        $('#container').append($newElement);\n        \n        // Fade in each element with a delay\n        $newElement.delay(index * 500).fadeIn(1000); // Adjust timing as needed\n    });\n});