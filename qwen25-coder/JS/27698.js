// Use event delegation for form submission\n$(document).on('submit', "form#login", function(e) {\n    e.preventDefault(); // Prevent default form submission\n\n    var usernameVal = $(this).find("input[name='username']").val();\n    var passwordVal = $(this).find("input[name='password']").val();\n\n    $.post("login.php", {username: usernameVal, password: passwordVal},\n        function(data) {\n            $("li.login").html(data);\n        });\n});\n\n// Use event delegation for logout click\n$(document).on('click', "a[name='logout']", function(e) {\n    e.preventDefault(); // Prevent default anchor behavior\n\n    $.post("logout.php",\n        function(data) {\n            $("li.login").html(data);\n        });\n});