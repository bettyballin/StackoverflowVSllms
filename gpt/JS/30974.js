$(document).ready(function() {\n    var appendedElements = [];\n\n    // Function to append and fade in new content\n    function appendContent() {\n        var html = "...";  // Replace with your actual HTML content\n        var $newElement = $('<div></div>').hide().append(html).fadeIn('slow');\n        $('#id').append($newElement);\n        appendedElements.push($newElement);\n    }\n\n    // Function to remove and fade out appended content\n    function removeAppendedContent() {\n        while (appendedElements.length > 0) {\n            var $element = appendedElements.pop();\n            $element.fadeOut('slow', function() {\n                $(this).remove();\n            });\n        }\n    }\n\n    // Example usage:\n    $('#appendButton').on('click', appendContent);  // Button to append content\n    $('#removeButton').on('click', removeAppendedContent);  // Button to remove content\n});