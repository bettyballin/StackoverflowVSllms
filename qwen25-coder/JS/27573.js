$(document).ready(function() {\n    $("#yourFormId").validate({\n        rules: {\n            yourInputField: {\n                maxlength: 10 // your max length limit\n            }\n        },\n        messages: {\n            yourInputField: {\n                maxlength: function(element) {\n                    return "Please enter no more than 10 characters. You've currently entered " + element.value.length + " characters.";\n                }\n            }\n        }\n    });\n});