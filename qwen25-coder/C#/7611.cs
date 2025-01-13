protected void CustomValidator_ServerValidate(object source, ServerValidateEventArgs args)\n{\n    string phoneNumber = txtPhone.Text.Trim();\n    string emailAddress = txtEmail.Text.Trim();\n\n    if (string.IsNullOrEmpty(phoneNumber) && string.IsNullOrEmpty(emailAddress))\n    {\n        args.IsValid = false;\n    }\n    else\n    {\n        args.IsValid = true;\n    }\n}