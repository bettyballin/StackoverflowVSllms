$(document).ready(function() {\n    $("form").submit(function(event) {\n        event.preventDefault(); // Prevent the default form submission\n        \n        // Call validation functions and wait for their completion\n        $.when(validateUsername(), validateEmail(), validatePassword()).then(function(usernameValid, emailValid, passwordValid) {\n            if (usernameValid[0] && emailValid && passwordValid) {\n                // Submit the form if all validations pass\n                event.target.submit();\n            } else {\n                // Handle validation errors\n                console.log("Validation failed.");\n            }\n        });\n    });\n\n    function validateUsername() {\n        var deferred = $.Deferred();\n\n        usernameInfo.addClass("sign_up_drill");\n        usernameInfo.text("checking...");\n        var b = username.val();\n        var filter = /^[a-zA-Z0-9_]+$/;\n        \n        $.post("../username_check.php", { su_username: b }, function(data) {\n            if (data == 'yes') {\n                username.addClass("error");\n                usernameInfo.text("sorry, that one's taken");\n                usernameInfo.addClass("error");\n                deferred.resolve(false);\n            } else if (!filter.test(b)) {\n                username.addClass("error");\n                usernameInfo.text("no funny characters please");\n                usernameInfo.addClass("error");\n                deferred.resolve(false);\n            } else {\n                username.removeClass("error");\n                usernameInfo.text("ok");\n                usernameInfo.removeClass("error");\n                deferred.resolve(true);\n            }\n        });\n\n        return deferred.promise();\n    }\n\n    function validateEmail() {\n        // Assume synchronous validation for email\n        // Replace with actual email validation logic if needed\n        var emailValid = true;\n        return emailValid;\n    }\n\n    function validatePassword() {\n        // Assume synchronous validation for password\n        // Replace with actual password validation logic if needed\n        var passwordValid = true;\n        return passwordValid;\n    }\n});