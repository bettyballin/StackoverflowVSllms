$(".my_link").click(function(event) {\n    event.preventDefault(); // Prevent the link from navigating immediately\n\n    var link = $(this).attr('href');\n\n    $.ajax({\n        url: link,\n        type: 'GET',\n        cache: false,\n        timeout: 30000,\n        error: function() {\n            window.location.href = link; // Navigate to the login page or target if AJAX fails\n        },\n        success: function(msg) {\n            if (parseFloat(msg)) {\n                // Do nothing, the link will not be followed as we prevented default action\n            } else {\n                window.location.href = link; // Navigate to the login page or target if server returns non-success message\n            }\n        }\n    });\n});