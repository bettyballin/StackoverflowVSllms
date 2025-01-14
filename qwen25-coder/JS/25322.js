$(document).ready(function() {\n    $('#submit-post').click(function() {\n        var postData = $('#post-input').val();\n\n        // Send AJAX request to server\n        $.ajax({\n            url: '/addForumPost', // endpoint on your server\n            type: 'POST',\n            data: { postContent: postData },\n            success: function(response) {\n                // Assuming response is sanitized and safe to use\n                var newPostHtml = '<div class="forum-post">' + escapeHtml(response.postContent) + '</div>';\n                $('#forum-posts').append(newPostHtml);\n                $('#post-input').val(''); // Clear input field\n            },\n            error: function() {\n                alert('Failed to post');\n            }\n        });\n    });\n});\n\n// Function to escape HTML characters\nfunction escapeHtml(string) {\n    return String(string)\n         .replace(/[&<>"'`=\/]/g, function (s) {\n             return entityMap[s];\n         });\n}\n\nvar entityMap = {\n  '&': '&amp;',\n  '<': '&lt;',\n  '>': '&gt;',\n  '"': '&quot;',\n  "'": '&#39;',\n  '/': '&#x2F;',\n  '=': '&#x3D;'\n};