function validateForm() {\n    if (ValidatorValidate(document.getElementById("<%= rfvFirst.ClientID %>")) &&\n        ValidatorValidate(document.getElementById("<%= rfvLast.ClientID %>")) &&\n        ValidatorValidate(document.getElementById("<%= rfvEmail.ClientID %>"))) {\n        // Submit the form\n    } else {\n        // Display an error message\n    }\n}\n\n// Bind the validateForm function to the form's submit event\ndocument.getElementById("form1").addEventListener("submit", validateForm);