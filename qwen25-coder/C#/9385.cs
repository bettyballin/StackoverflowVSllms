string appDataPath = Environment.GetFolderPath(Environment.SpecialFolder.ApplicationData);\nstring configFilePath = Path.Combine(appDataPath, "YourApp", "application.exe.config");\n\n// Load from this path instead and save user-specific settings here.