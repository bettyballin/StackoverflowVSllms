// To check if a specific validation group is valid:\nvar isValid = Page_ClientValidate('MyValidationGroup');\nif (isValid) {\n    // The specified validation group is valid.\n} else {\n    // There are validation errors in the specified validation group.\n}