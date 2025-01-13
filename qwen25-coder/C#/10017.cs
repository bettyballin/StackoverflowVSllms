public void InitializeSessionSettings()\n{\n    UserModel model = new UserModel\n    {\n        Setting1 = "SpecificValueForThisSession",\n        Setting2 = 42\n    };\n    \n    // Save settings to session\n    model.SaveToSession();\n}\n\n// Retrieving settings from session for current user\nUserModel currentUserModel = UserModel.FromSession();\nif (currentUserModel != null)\n{\n    // Use the settings from the session\n}