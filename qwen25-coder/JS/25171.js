function clearTextFields() {\n    var textFields = document.querySelectorAll('input[type="text"]');\n    textFields.forEach(function(field) {\n        field.value = '';\n    });\n}