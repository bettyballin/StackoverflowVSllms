$(document).ready(function() {\n    $('#menu a').click(function(e) {\n        e.preventDefault(); // Prevent the default link behavior\n        var page = $(this).data('page'); // Get data-page attribute value\n\n        $.ajax({\n            url: 'handler.php', // AJAX handler script\n            method: 'GET',\n            data: { page: page },\n            success: function(response) {\n                $('#main').html(response); // Update main content div with response\n            }\n        });\n    });\n});