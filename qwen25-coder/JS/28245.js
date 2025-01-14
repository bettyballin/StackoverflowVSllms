$(document).ready(function() {\n    $('.user-link').click(function(event) {\n        event.preventDefault(); // Prevent the default action of the link\n        var userId = $(this).data('user-id'); // Get the user ID from data attribute\n\n        $.ajax({\n            url: 'save-user.php', // Your PHP script\n            method: 'POST',\n            data: {userId: userId}, // Data to send\n            success: function(response) {\n                console.log('User saved successfully:', response);\n            },\n            error: function(xhr, status, error) {\n                console.error('Error saving user:', error);\n            }\n        });\n    });\n});