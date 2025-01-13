// Install the SQL Server IntelliSense plugin\nusing System;\nusing System.Collections.Generic;\nusing Microsoft.VisualStudio.Shell;\n\npublic class SqlIntelliSenseInstaller : Package\n{\n    protected override void Initialize()\n    {\n        base.Initialize();\n\n        // Install the plugin\n        var installer = new SqlIntelliSenseInstaller();\n        installer.Install();\n    }\n}