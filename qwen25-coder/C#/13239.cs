bool isActive = ActiveDirectoryHelper.IsUserActive("username");\nif (isActive)\n{\n    // Send email or perform other actions\n}\nelse\n{\n    // Do not send email as user is inactive.\n}