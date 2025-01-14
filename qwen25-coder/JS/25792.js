$(document).ready(function() {\n    $("input[type=submit]").click(async function(event) {\n        event.preventDefault(); // Prevent form submission to handle it manually\n\n        var valid = true;\n\n        // email - check required and valid\n        var email = $("input[name='email']");\n        var emailtrim = jQuery.trim(email.val());\n\n        try {\n            // Check if the email exists in the database\n            var isEmailExist = await EmailExist(emailtrim);\n            if (isEmailExist) {\n                valid = false;\n                alert("Email already exists.");\n            }\n        } catch (error) {\n            console.error("Error checking email existence", error);\n            valid = false; // Optionally mark as invalid on error\n        }\n\n        if (valid) {\n            this.form.submit(); // Submit the form manually if everything is okay\n        }\n    });\n\n    function EmailExist(emailval) {\n        return new Promise((resolve, reject) => {\n            $.ajax({\n                type: "POST",\n                url: "/Account/EmailExist",\n                data: { 'email': emailval },\n                success: function(result) {\n                    resolve(result.indb);\n                },\n                error: function(error) {\n                    console.error("AJAX Error in EmailExist", error);\n                    reject(error);\n                }\n            });\n        });\n    }\n});