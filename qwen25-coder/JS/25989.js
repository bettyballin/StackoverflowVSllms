$(document).ready(function () {\n    // Add custom validation method with async option support\n    $.validator.addMethod('authenticate', function (value, element, callback) {\n        $.getJSON("./json/authenticate.do", { password: value }, function (json) {\n            callback(json.success);\n        });\n        return "pending";\n    }, 'Wrong password');\n\n    $('form#changePasswordForm').validate({\n        rules: {\n            repeat_new_password: { equalTo: "#new_password" },\n            password: { authenticate: true }\n        },\n        submitHandler: function (form) {\n            $(form).ajaxSubmit({\n                dataType: "json",\n                success: function (json) {\n                    alert("foo");\n                }\n            });\n        }\n    });\n});