public class MainMenu\n{\n    private List<IModule> _modules;\n\n    public MainMenu(string modulesPath)\n    {\n        ModuleLoader loader = new ModuleLoader();\n        _modules = loader.LoadModules(modulesPath);\n        PopulateMenu();\n    }\n\n    private void PopulateMenu()\n    {\n        foreach (IModule module in _modules)\n        {\n            // Example: Add a button for each module\n            Button moduleButton = new Button();\n            moduleButton.Text = module.ModuleName;\n            moduleButton.Click += (sender, e) => module.Execute();\n            \n            // Add the button to the main menu\n            // Assuming there's a method AddButton to add buttons to the UI\n            AddButton(moduleButton);\n        }\n    }\n    \n    private void AddButton(Button button)\n    {\n        // Implementation to add button to the UI\n    }\n}