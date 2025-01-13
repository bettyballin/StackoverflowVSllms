using System;\nusing TestStack.White.Factory;\nusing TestStack.White.UIItems.Finders;\n\nclass Program\n{\n    static void Main()\n    {\n        // Launch the application\n        Application application = Application.Launch("YourApplicationPath.exe");\n\n        // Get a hold of the main window\n        var mainWindow = application.GetWindow(SearchCriteria.ByText("MainWindowTitle"), InitializeOption.NoCache);\n\n        // Find and interact with controls\n        var button = mainWindow.Get<Button>(SearchCriteria.ByText("ButtonText"));\n        button.Click();\n\n        // Close the application\n        application.Close();\n    }\n}