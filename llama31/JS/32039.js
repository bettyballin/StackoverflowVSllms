function send_requestSearch(input) {\n    var searchQuery = input.value;\n    $.ajax({\n        type: 'GET',\n        url: 'search.php',\n        data: {search: searchQuery},\n        success: function(data) {\n            $('#livesearch').html(data);\n            // Make list items selectable\n            $('#livesearch li').on('click', function() {\n                input.value = $(this).text();\n            });\n        }\n    });\n}