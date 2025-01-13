using Microsoft.Build.Construction;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Create a new project\n        ProjectRootElement project = ProjectRootElement.Create("MyProject.csproj");\n\n        // Add a target framework\n        project.AddProperty("TargetFramework", "net35");\n\n        // Add a compile item\n        project.AddItem("Compile", "Program.cs");\n\n        // Add a reference\n        project.AddItem("Reference", "System");\n\n        // Save the project\n        project.Save();\n    }\n}