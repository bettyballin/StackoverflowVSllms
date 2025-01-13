$(document).ready(function () {\n    // Add custom validation method\n    $.validator.addMethod('authenticate', function (value, element, param) {\n        var response = false;\n        $.ajax({\n            url: "./json/authenticate.do",\n            data: { password: value },\n            dataType: "json",\n            async: false, // Make the request synchronous\n            success: function (json) {\n                response = json.success;\n            }\n        });\n        return response;\n    }, 'Wrong password');\n\n    $('form#changePasswordForm').validate({\n        rules: {\n            repeat_new_password: { equalTo: "#new_password" },\n            password: { authenticate: true }\n        },\n        submitHandler: function (form) {\n            $(form).ajaxSubmit({\n                dataType: "json",\n                success: function (json) {\n                    alert("foo");\n                }\n            });\n        }\n    });\n});