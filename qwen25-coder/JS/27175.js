$(document).ready(function() {\n    $('#tag-input').on('input', function() {\n        var query = $(this).val();\n        if (query.length > 2) { // Trigger autocomplete after 3 characters\n            $.ajax({\n                url: 'get_tags.php', // Replace with your server endpoint\n                method: 'GET',\n                data: { q: query },\n                success: function(data) {\n                    var suggestions = JSON.parse(data);\n                    $('#suggestions').empty();\n                    suggestions.forEach(function(tag) {\n                        $('#suggestions').append('<li>' + tag + '</li>');\n                    });\n                }\n            });\n        } else {\n            $('#suggestions').empty(); // Clear the list if query is too short\n        }\n    });\n\n    // Clicking on a suggestion fills it into the input field\n    $('#suggestions').on('click', 'li', function() {\n        $('#tag-input').val($(this).text());\n        $('#suggestions').empty();\n    });\n});