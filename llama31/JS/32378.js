function validateEmail() {\n    var email = document.getElementById('<%= txtEmail.ClientID %>').value;\n    PageMethods.ValidateEmail(email, OnSucceeded, OnFailed);\n}\n\nfunction OnSucceeded(result) {\n    if (result) {\n        alert('Email is valid');\n    } else {\n        alert('Email is invalid');\n    }\n}\n\nfunction OnFailed(error) {\n    alert('Error occurred');\n}