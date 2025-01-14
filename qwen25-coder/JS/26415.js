$('#login_btn').click(function(){\n    var username = $('#login_username').val();\n    var password = $('#login_password').val();\n    $.post("login.php", { username: username, password: password },\n        function(data){\n            console.log(data); // Log the full response for debugging\n            if(data.trim() === 'Incorrect password'){ // Use trim to remove any leading/trailing whitespace\n                $('#login_callback').html(data);    \n            } else {\n                $('#login').html(data);\n            }\n        }\n    );                     \n});