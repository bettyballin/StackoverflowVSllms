using System.Windows;\nusing Costura;\n\npublic partial class App : Application\n{\n    protected override void OnStartup(StartupEventArgs e)\n    {\n        // Load embedded dependencies\n        CosturaUtility.LoadDependencies();\n        base.OnStartup(e);\n    }\n}