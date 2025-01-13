using RoboSharp;\n\nclass Program\n{\n    static void Main()\n    {\n        var copyOptions = new CopyOptions\n        {\n            Source = @"C:\SourceDirectory",\n            Destination = @"D:\DestinationDirectory",\n            CopySubdirectories = true,\n            CopyAll = true,\n            Mirror = true\n        };\n\n        var robocopy = new RoboCommand\n        {\n            CopyOptions = copyOptions\n        };\n\n        robocopy.OnCommandCompleted += (sender, e) =>\n        {\n            if (e.Error == null)\n            {\n                Console.WriteLine("File synchronization completed successfully.");\n            }\n            else\n            {\n                Console.WriteLine($"Error during file synchronization: {e.Error.Message}");\n            }\n        };\n\n        robocopy.Start();\n    }\n}