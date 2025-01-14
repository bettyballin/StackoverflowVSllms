$(function () {\n    $('#SaveButton').click(function (e) {\n        e.preventDefault();\n        $.ajax({\n            type: "POST",\n            url: "UserProfilePage.aspx/UpdateUserProfile",\n            data: JSON.stringify({ profile: { Username: $('#UsernameTextBox').val() } }),\n            contentType: "application/json; charset=utf-8",\n            dataType: "json",\n            success: function (response) {\n                alert('Profile updated successfully!');\n            }\n        });\n    });\n\n    // Load user profile asynchronously\n    $.ajax({\n        type: "POST",\n        url: "UserProfilePage.aspx/GetUserProfile",\n        data: JSON.stringify({ username: $('#UsernameTextBox').val() }),\n        contentType: "application/json; charset=utf-8",\n        dataType: "json",\n        success: function (response) {\n            // Assume response has a d property\n            $('#UsernameTextBox').val(response.d.Username);\n        }\n    });\n});