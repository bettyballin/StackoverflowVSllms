$(function ()\n{\n    $.validator.addMethod("loginRegex", function(value, element) {\n        return this.optional(element) || /^[a-z0-9\-]+$/i.test(value);\n    }, "Username must contain only letters, numbers, or dashes.");\n\n    $("#signupForm").validate({\n        rules: {\n            "login": {\n                required: true,\n                loginRegex: true,\n            }\n        },\n        messages: {\n            "login": {\n                required: "You must enter a login name",\n                loginRegex: "Login format not valid"\n            }\n        }\n    });\n});