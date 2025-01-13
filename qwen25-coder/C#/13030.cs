using System;\nusing System.IO;\nusing Microsoft.Build.Framework;\nusing Microsoft.Build.Utilities;\n\npublic class ModifySourceCodeTask : Task\n{\n    [Required]\n    public ITaskItem[] Sources { get; set; }\n\n    [Output]\n    public ITaskItem[] ModifiedSources { get; set; }\n\n    public override bool Execute()\n    {\n        var modifiedFiles = new List<ITaskItem>();\n\n        try\n        {\n            foreach (var source in Sources)\n            {\n                string originalPath = source.ItemSpec;\n                string temporaryFilePath = Path.GetTempFileName() + ".cs";\n\n                // Read the content of the file.\n                string content = File.ReadAllText(originalPath);\n\n                // Modify the content by adding a comment at the top.\n                string modifiedContent = $"// This file was modified using MSBuild task.\n{content}";\n\n                // Write the modified content to a new temporary file.\n                File.WriteAllText(temporaryFilePath, modifiedContent);\n\n                // Add the path of the modified file as an output item.\n                modifiedFiles.Add(new TaskItem(temporaryFilePath));\n            }\n\n            ModifiedSources = modifiedFiles.ToArray();\n            return true;\n        }\n        catch (Exception ex)\n        {\n            Log.LogErrorFromException(ex);\n            return false;\n        }\n    }\n}